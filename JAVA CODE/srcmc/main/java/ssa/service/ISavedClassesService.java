package ssa.service;

import java.util.List;

import ssa.entity.SavedClasses;

public interface ISavedClassesService {

	List<SavedClasses> getSavedClassesById(int login_id);
	SavedClasses getSavedClassById(int login_id, int class_id);
	void deleteSavedClasses(SavedClasses savedClasses);
	void insertSavedClasses(SavedClasses savedClasses);
}
