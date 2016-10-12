package ssa.dao;

import java.util.List;

import ssa.entity.Employee;

public interface IEmployeeDAO {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(int employeeId);
	boolean addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int employeeId);
	
}
