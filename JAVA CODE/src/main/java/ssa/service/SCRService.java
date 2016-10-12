package ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssa.dao.ISCRDAO;
import ssa.entity.SCR;

@Service
public class SCRService implements ISCRService{

	@Autowired
	private ISCRDAO SCRDAO;
	
	@Override
	public List<SCR> getAllSCR() {
		return SCRDAO.getAllSCR();
	}

	@Override
	public SCR getSCRById(int scrId) {
		return SCRDAO.getSCRById(scrId);
	}

	@Override
	public boolean addSCR(SCR scr) {
		return SCRDAO.addSCR(scr);
	}

	@Override
	public void updateSCR(SCR scr) {
		SCRDAO.updateSCR(scr);
	}

	@Override
	public void deleteSCR(int scrId) {
		SCRDAO.deleteSCR(scrId);
	}

	@Override
	public List<SCR> getSCRBySid(int studentId) {
		return SCRDAO.getSCRBySid(studentId);
	}

	@Override
	public List<SCR> getSCRByCid(int classId) {
		return SCRDAO.getSCRByCid(classId);
	}

}
