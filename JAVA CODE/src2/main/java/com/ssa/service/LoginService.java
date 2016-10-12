package com.ssa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.dao.ILoginDAO;
import com.ssa.entity.Login;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	private ILoginDAO loginDAO;


	@Override
	public Login getLoginById(String id) {
		return loginDAO.getLoginById(id);
		}
	
	public boolean doesLoginExist(String id) {
		return loginDAO.doesLoginExist(id);
	};

}
