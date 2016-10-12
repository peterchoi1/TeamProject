package ssa.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.SCR;

@Transactional
@Repository
public class SCRDAO implements ISCRDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;


	@SuppressWarnings("unchecked")
	@Override
	public List<SCR> getSCRBySid(int studentId) {
	    String hql = "FROM SCR as s where s.student_id = " + studentId + " ORDER BY s.id";
	    return (List<SCR>) hibernateTemplate.find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SCR> getSCRByCid(int classId) {
	    String hql = "FROM SCR as s where s.class_id = " + classId + " ORDER BY s.id";
	    return (List<SCR>) hibernateTemplate.find(hql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SCR> getAllSCR() {
	    String hql = "FROM SCR as s ORDER BY s.id";
	    return (List<SCR>) hibernateTemplate.find(hql);
	}

	@Override
	public SCR getSCRById(int scrId) {
	    return (SCR) hibernateTemplate.get(SCR.class,scrId);
	}

	@Override
	public boolean addSCR(SCR scr) {
		try {
			hibernateTemplate.saveOrUpdate(scr);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public void updateSCR(SCR scr) {
		hibernateTemplate.saveOrUpdate(scr);
	}

	@Override
	public void deleteSCR(int scrId) {
	    SCR scr = (SCR) hibernateTemplate.load(SCR.class, scrId);
	    hibernateTemplate.delete(scr);
	}

}
