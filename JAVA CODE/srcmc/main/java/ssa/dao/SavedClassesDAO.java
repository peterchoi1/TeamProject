package ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ssa.entity.SavedClasses;

@Transactional
@Repository
public class SavedClassesDAO implements ISavedClassesDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked"
    		)
    @Override
	public List<SavedClasses> getSavedClassesById(int login_id) {
		 String hql = "FROM SavedClasses where login_id = '" + login_id + "'";
	     return (List<SavedClasses>) hibernateTemplate.find(hql);
	}
    
    @Override
    public SavedClasses getSavedClassById(int login_id, int class_id) {
		 String hql = "FROM SavedClasses where login_id = '" + login_id + "' and class_id = '" + class_id + '"';
	     return (SavedClasses) hibernateTemplate.find(hql).get(0);
	}
   

	@Override
	public void deleteSavedClasses(SavedClasses savedClasses) {
	    hibernateTemplate.delete(savedClasses);
	}
	
	@Override
	public void insertSavedClasses(SavedClasses savedClasses) {
	    hibernateTemplate.save(savedClasses);
	}
}


