package ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.Class;

@Transactional
@Repository
public class ClassDAO implements IClassDAO{

	@Autowired
	private HibernateTemplate  hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Class> getAllClasses() {
	    String hql = "FROM Class as s ORDER BY s.id";
	    return (List<Class>) hibernateTemplate.find(hql);
	}

	@Override
	public Class getClassById(int aClassId) {
	    return (Class) hibernateTemplate.get(Class.class,aClassId);
	}

	@Override
	public boolean addClass(Class aClass) {
		try {
			hibernateTemplate.saveOrUpdate(aClass);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public void updateClass(Class aClass) {
		hibernateTemplate.saveOrUpdate(aClass);
	}

	@Override
	public void deleteClass(int aClassId) {
	    Class aClass = (Class) hibernateTemplate.load(Class.class, aClassId);
	    hibernateTemplate.delete(aClass);
//		hibernateTemplate.delete(hibernateTemplate.get(Class.class, aClassId));;
	}

}
