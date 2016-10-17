package ssa.dao;

import java.util.List;

import ssa.entity.Login;

public interface ILoginDAO {
	
	boolean doesLoginExist(String user_name);
	Login getLoginById(String user_name);
	void deleteLogin(Login login);
	void insertLogin(Login login);
	void changePassword(Login login);

}
