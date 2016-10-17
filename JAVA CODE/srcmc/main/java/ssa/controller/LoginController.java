package ssa.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssa.entity.Login;
import ssa.service.ILoginService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class LoginController {
	
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value= "/login/", method = RequestMethod.POST)
    public ResponseEntity<Integer> loginCheck(Login loginData) {
			String user_name = loginData.getUser_name();
			String password = loginData.getPassword();
			System.out.println(user_name + " " + password);
    		Integer loginCode = 3;
			boolean loginCheck = false;
			loginCheck = loginService.doesLoginExist(user_name);
			if (loginCheck == true) {
				Login login = loginService.getLoginById(user_name);
					if (login.getPassword().equals(password)) {
							//Successfully logs in and passes user's ID
							loginCode = login.getId();
					}
					else {
						//Wrong password code
						loginCode = 2;
					}
			}
			else {
				//Invalid User ID code
				loginCode = 3;
			}
	       	return new ResponseEntity<Integer>(loginCode, HttpStatus.OK);
	}
	
	
	
	
	
	
	@RequestMapping(value= "/deletelogin/{user_name}", method = RequestMethod.DELETE)
    public ResponseEntity<Login> deleteStudent(@PathVariable("user_name") String user_name) {
		Login login = loginService.getLoginById(user_name);
        loginService.deleteLogin(login);
        return new ResponseEntity<Login>(HttpStatus.OK);
    }
	
	
	@RequestMapping(value= "/login/insert/", method = RequestMethod.POST)
	public void insertLogin(Login loginData)  {
				Login login = new Login(loginData.getPassword(), loginData.getUser_name());
	       		loginService.insertLogin(login);
    }
	
	@RequestMapping(value= "/login/changepassword/", method = RequestMethod.PUT)
	public void changePassword(Login loginData)  {
	       		loginService.changePassword(loginData);
    }
	
}
