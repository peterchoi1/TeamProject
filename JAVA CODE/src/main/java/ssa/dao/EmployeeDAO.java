package ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Employee;

@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
	    String hql = "FROM Employee as e ORDER BY e.id";
	    return (List<Employee>) hibernateTemplate.find(hql);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
	    return (Employee) hibernateTemplate.get(Employee.class,employeeId);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		try {
			hibernateTemplate.saveOrUpdate(employee);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public void updateEmployee(Employee employee) {
		hibernateTemplate.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
	    Employee employee = (Employee) hibernateTemplate.load(Employee.class, employeeId);
	    hibernateTemplate.delete(employee);
	}

}
