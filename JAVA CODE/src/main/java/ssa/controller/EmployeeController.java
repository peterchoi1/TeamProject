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
import ssa.entity.Employee;
import ssa.service.IEmployeeService;

@CrossOrigin
@RestController
//@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value= "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employee = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

	@RequestMapping(value= "/deleteemployee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
	
		
	@RequestMapping(value= "/addemployee", method = RequestMethod.POST)
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		
		Employee newemployee = new Employee();
		newemployee.setFirst_name(employee.getFirst_name());
		newemployee.setLast_name(employee.getLast_name());
		newemployee.setYears_experience(employee.getYears_experience());
		newemployee.setIs_tenured(employee.getIs_tenured());
		newemployee.setRole_id(employee.getRole_id());
		System.out.println("Instantiated:" + newemployee);

        boolean condition = employeeService.addEmployee(newemployee);
        System.out.println(condition);
        
        if (condition == true) {
        	return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }       
    }
	
	@RequestMapping(value="/updateemployee", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
