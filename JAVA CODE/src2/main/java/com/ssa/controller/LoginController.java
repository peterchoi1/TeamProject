package com.ssa.controller;

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

import com.ssa.entity.Login;
import com.ssa.service.ILoginService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value= "/login/", method = RequestMethod.POST)
    public ResponseEntity<Integer> loginCheck(Login loginData) {
			String id = loginData.getId();
			String password = loginData.getPassword();
    		Integer loginCode = 3;
			boolean loginCheck = false;
			loginCheck = loginService.doesLoginExist(id);
			if (loginCheck == true) {
				Login login = loginService.getLoginById(id);
					if (login.getPassword().equals(password)) {
						loginCode = login.getAdmin();
					}
					else {
						loginCode = 3;
					}
			}
			else {
				loginCode = 4;
			}
	       	return new ResponseEntity<Integer>(loginCode, HttpStatus.OK);
	}

}
