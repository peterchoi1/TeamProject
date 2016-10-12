package ssa.service;

import java.util.List;

import ssa.entity.SCR;

public interface ISCRService {

	List<SCR> getAllSCR();
	SCR getSCRById(int scrId);
	boolean addSCR(SCR scr);
	void updateSCR(SCR scr);
	void deleteSCR(int scrId);
	List<SCR> getSCRBySid(int studentId);
	List<SCR> getSCRByCid(int classId);



	
}
