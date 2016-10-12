package ssa.dao;

import java.util.List;

import ssa.entity.SCR;

public interface ISCRDAO {

	List<SCR> getAllSCR();
	SCR getSCRById(int id);
	List<SCR> getSCRBySid(int studentId);
	List<SCR> getSCRByCid(int classId);
	boolean addSCR(SCR scr);
	void updateSCR(SCR scr);
	void deleteSCR(int scrId);
	
}
