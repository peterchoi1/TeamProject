package com.ssa.service;

import java.util.List;

import com.ssa.entity.Login;

public interface ILoginService {

	Login getLoginById(String id);
	boolean doesLoginExist(String id);
}
