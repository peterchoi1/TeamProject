package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.IEmployeeDAO;
import ssa.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

}
