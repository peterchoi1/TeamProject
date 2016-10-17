package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.ISavedClassesDAO;
import ssa.entity.SavedClasses;

@Service
public class SavedClassesService implements ISavedClassesService {
	
	@Autowired
	private ISavedClassesDAO savedClassesDAO;


	@Override
	public List<SavedClasses> getSavedClassesById(int login_id) {
		return savedClassesDAO.getSavedClassesById(login_id);
		}
	
	@Override
	public SavedClasses getSavedClassById(int login_id, int class_id) {
		return savedClassesDAO.getSavedClassById(login_id, class_id);
		}
	
	@Override
	public void deleteSavedClasses(SavedClasses savedClasses) {
		savedClassesDAO.deleteSavedClasses(savedClasses);
	}
	
	@Override
	public void insertSavedClasses(SavedClasses savedClasses) {
		savedClassesDAO.insertSavedClasses(savedClasses);
	}
}
