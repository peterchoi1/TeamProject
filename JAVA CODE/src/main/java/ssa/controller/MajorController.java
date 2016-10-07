package ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ssa.entity.Major;
import ssa.service.IMajorService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class MajorController {

	@Autowired
	private IMajorService majorService;
	
	@RequestMapping(value= "/majors", method = RequestMethod.GET)
    public ResponseEntity<List<Major>> getAllMajors() {
        List<Major> major = majorService.getAllMajors();
        return new ResponseEntity<List<Major>>(major, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/major/{id}", method = RequestMethod.GET)
    public ResponseEntity<Major> getMajorById(@PathVariable("id") Integer id) {
        Major major = majorService.getMajorById(id);
        return new ResponseEntity<Major>(major, HttpStatus.OK);
    }

	@RequestMapping(value= "/deletemajor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Major> deleteMajor(@PathVariable("id") Integer id) {
        majorService.deleteMajor(id);
        return new ResponseEntity<Major>(HttpStatus.OK);
    }
	
		
	@RequestMapping(value= "/addmajor", method = RequestMethod.POST)
    public ResponseEntity<Void> addMajor(@RequestBody Major major) {
		
		Major newmajor = new Major();
		newmajor.setDescription(major.getDescription());
		newmajor.setReq_sat(major.getReq_sat());
		System.out.println("Instantiated:" + newmajor);

        boolean condition = majorService.addMajor(newmajor);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updatemajor", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateMajor(@RequestBody Major major) {
        majorService.updateMajor(major);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
