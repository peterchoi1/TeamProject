package ssa.dao;

import java.util.List;
import ssa.entity.Class;

public interface IClassDAO {

	List<Class> getAllClasses();
	Class getClassById(int aClassId);
	boolean addClass(Class aClass);
	void updateClass(Class aClass);
	void deleteClass(int aClassId);
}
