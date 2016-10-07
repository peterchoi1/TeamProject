package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.IMajorDAO;
import ssa.entity.Major;

@Service
public class MajorService implements IMajorService{

	@Autowired
	private IMajorDAO majorDAO;
	
	@Override
	public List<Major> getAllMajors() {
		return majorDAO.getAllMajors();
	}

	@Override
	public Major getMajorById(int majorId) {
		return majorDAO.getMajorById(majorId);
	}

	@Override
	public boolean addMajor(Major major) {
		return majorDAO.addMajor(major);
	}

	@Override
	public void updateMajor(Major major) {
		majorDAO.updateMajor(major);
	}

	@Override
	public void deleteMajor(int majorId) {
		majorDAO.deleteMajor(majorId);
	}

}
