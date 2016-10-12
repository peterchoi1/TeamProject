package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.IClassDAO;
import ssa.entity.Class;

@Service
public class ClassService implements IClassService{

	@Autowired
	private IClassDAO ClassDAO;
	
	@Override
	public List<Class> getAllClasses() {
		return ClassDAO.getAllClasses();
	}

	@Override
	public Class getClassById(int aClassId) {
		return ClassDAO.getClassById(aClassId);
	}

	@Override
	public boolean addClass(Class aClass) {
		return ClassDAO.addClass(aClass);
	}

	@Override
	public void updateClass(Class aClass) {
		ClassDAO.updateClass(aClass);
	}

	@Override
	public void deleteClass(int aClassId) {
		ClassDAO.deleteClass(aClassId);
	}

}
