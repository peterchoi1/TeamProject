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
import ssa.entity.Class;
import ssa.entity.Student;
import ssa.service.IClassService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class ClassController {

	@Autowired
	private IClassService classService;
	
	@RequestMapping(value= "/classes", method = RequestMethod.GET)
    public ResponseEntity<List<Class>> getAllClasses() {
        List<Class> aClass = classService.getAllClasses();
        return new ResponseEntity<List<Class>>(aClass, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/class/{id}", method = RequestMethod.GET)
    public ResponseEntity<Class> getClassById(@PathVariable("id") Integer id) {
        Class aClass = classService.getClassById(id);
        return new ResponseEntity<Class>(aClass, HttpStatus.OK);
    }

	@RequestMapping(value= "/deleteclass/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Class> deleteClass(@PathVariable("id") Integer id) {
        classService.deleteClass(id);
        return new ResponseEntity<Class>(HttpStatus.OK);
    }	
		
	@RequestMapping(value= "/addclass", method = RequestMethod.POST)
    public ResponseEntity<Void> addClass(@RequestBody Class aClass) {
		
		Class newclass = new Class();
		newclass.setSubject(aClass.getSubject());
		newclass.setSection(aClass.getSection());
		newclass.setInstructor_id(aClass.getInstructor_id());
		newclass.setSemester(aClass.getSemester());
		newclass.setYear(aClass.getYear());
		System.out.println("Instantiated:" + newclass);

        boolean condition = classService.addClass(newclass);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updateclass", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateClass(@RequestBody Class aClass) {
        classService.updateClass(aClass);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
