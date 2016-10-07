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
import ssa.entity.Student;
import ssa.service.IStudentService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value= "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

	@RequestMapping(value= "/deletestudent/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }
	
		
	@RequestMapping(value= "/addstudent", method = RequestMethod.POST)
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
		
		Student newstudent = new Student();
		newstudent.setFirst_name(student.getFirst_name());
		newstudent.setLast_name(student.getLast_name());
		newstudent.setGpa(student.getGpa());
		newstudent.setSat(student.getSat());
		newstudent.setMajor_id(student.getMajor_id());
		System.out.println("Instantiated:" + newstudent);

        boolean condition = studentService.addStudent(newstudent);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updatestudent", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
		 
//		Student student = studentService.getStudentById(id);
//		student.setFirst_name(fname);
//		student.setLast_name(lname);
//		student.setGpa(gpa);
//		student.setSat(sat);
//		student.setMajor_id(majorid);
//		System.out.println("Modified instance:" + student);

        studentService.updateStudent(student);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
