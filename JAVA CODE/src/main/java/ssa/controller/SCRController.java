package ssa.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ssa.entity.SCR;
import ssa.service.ISCRService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class SCRController {

	@Autowired
	private ISCRService scrService;
	
	@RequestMapping(value= "/scrs", method = RequestMethod.GET)
    public ResponseEntity<List<SCR>> getAllSCR() {
        List<SCR> scr = scrService.getAllSCR();
        return new ResponseEntity<List<SCR>>(scr, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/scr/{id}", method = RequestMethod.GET)
    public ResponseEntity<SCR> getSCRById(@PathVariable("id") Integer id) {
        SCR scr = scrService.getSCRById(id);
        return new ResponseEntity<SCR>(scr, HttpStatus.OK);
    }

	@RequestMapping(value= "/scrbysid/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<SCR>> getSCRBySid(@PathVariable("id") Integer studentId) {
        List<SCR> scr = scrService.getSCRBySid(studentId);
        return new ResponseEntity<List<SCR>>(scr, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/scrbycid/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<SCR>> getSCRByCid(@PathVariable("id") Integer classId) {
        List<SCR> scr = scrService.getSCRByCid(classId);
        return new ResponseEntity<List<SCR>>(scr, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/deletescr/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SCR> deleteSCR(@PathVariable("id") Integer id) {
        scrService.deleteSCR(id);
        return new ResponseEntity<SCR>(HttpStatus.OK);
    }
	
		
	@RequestMapping(value= "/addSCR", method = RequestMethod.POST)
    public ResponseEntity<Void> addSCR(@RequestBody SCR scr) {
		
		SCR newscr = new SCR();
		newscr.setStudent_id(scr.getStudent_id());
		newscr.setClass_id(scr.getClass_id());
		newscr.setGrade(scr.getGrade());
		newscr.setStatus(scr.getStatus());
		System.out.println("Instantiated:" + newscr);

        boolean condition = scrService.addSCR(newscr);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updatescr", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSCR(@RequestBody SCR scr) {
        scrService.updateSCR(scr);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
