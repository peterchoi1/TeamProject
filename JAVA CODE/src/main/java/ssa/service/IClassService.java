package ssa.service;

import java.util.List;

import ssa.entity.Class;

public interface IClassService {

	List<Class> getAllClasses();
	Class getClassById(int aClassId);
	boolean addClass(Class aClass);
	void updateClass(Class aClass);
	void deleteClass(int aClassId);
	
}
