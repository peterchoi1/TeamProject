package ssa.service;

import java.util.List;

import ssa.entity.Major;

public interface IMajorService {

	List<Major> getAllMajors();
	Major getMajorById(int majorId);
	boolean addMajor(Major major);
	void updateMajor(Major major);
	void deleteMajor(int majorId);
}
