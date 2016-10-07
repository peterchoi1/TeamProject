package ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Major;

@Transactional
@Repository
public class MajorDAO implements IMajorDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Major> getAllMajors() {
	    String hql = "FROM Major as m ORDER BY m.id";
	    return (List<Major>) hibernateTemplate.find(hql);
	}

	@Override
	public Major getMajorById(int majorId) {
	    return (Major) hibernateTemplate.get(Major.class,majorId);
	}

	@Override
	public boolean addMajor(Major major) {
		try {
			hibernateTemplate.saveOrUpdate(major);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public void updateMajor(Major major) {
		hibernateTemplate.saveOrUpdate(major);
	}

	@Override
	public void deleteMajor(int majorId) {
	    Major major = (Major) hibernateTemplate.load(Major.class, majorId);
	    hibernateTemplate.delete(major);
//		hibernateTemplate.delete(hibernateTemplate.get(Major.class, majorId));;
	}

}
