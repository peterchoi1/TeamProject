package ssa.service;

import java.util.List;

import ssa.entity.Login;

public interface ILoginService {

	Login getLoginById(String user_name);
	boolean doesLoginExist(String user_name);
	void deleteLogin(Login login);
	void insertLogin(Login login);
	void changePassword(Login login);
}
