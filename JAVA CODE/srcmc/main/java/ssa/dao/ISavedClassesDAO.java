package ssa.dao;

import java.util.List;

import ssa.entity.SavedClasses;

public interface ISavedClassesDAO {
	
	List<SavedClasses> getSavedClassesById(int login_id);
	SavedClasses getSavedClassById(int login_id, int class_id);
	void deleteSavedClasses(SavedClasses savedClasses);
	void insertSavedClasses(SavedClasses savedClasses);

}
