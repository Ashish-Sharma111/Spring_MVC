package com.demo.service;

import com.demo.model.MyUser;

public interface LoginService {

	public MyUser validateUser(String unm, String passwd);
	
	
	}


