package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.entity.Login;

@Transactional
@Repository
public class LoginDAO implements ILoginDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
	public boolean doesLoginExist(String id) {
    	boolean loginCheck = false;
		 String hql = "FROM Login where id = '" + id + "'";
		 hibernateTemplate.find(hql);
		 if (hibernateTemplate.find(hql).size() > 0) {
			 loginCheck = true;
		 }
    		return loginCheck; 
    }
    
	public Login getLoginById(String id) {
		 String hql = "FROM Login where id = '" + id + "'";
	     return (Login) hibernateTemplate.find(hql).get(0);
	}
}


