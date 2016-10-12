package com.ssa.dao;

import java.util.List;

import com.ssa.entity.Login;

public interface ILoginDAO {
	
	boolean doesLoginExist(String id);
	Login getLoginById(String id);

}
