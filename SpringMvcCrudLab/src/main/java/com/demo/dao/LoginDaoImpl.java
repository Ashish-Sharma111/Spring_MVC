package com.demo.dao;

import com.demo.model.MyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class LoginDaoImpl implements LoginDao {
    @Autowired 
    private JdbcTemplate jdbcTemplate;
	@Override
	public MyUser checkUser(String unm, String passwd) {
		  
	try {	String str="select username,password,roles from myuser where username=? and password=?"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ;
		return jdbcTemplate.queryForObject(str, new Object[] {unm,passwd},BeanPropertyRowMapper.newInstance(MyUser.class));
	}catch(EmptyResultDataAccessException e){
		System.out.println("not found"+e.getMessage());
		return null;
		
	}
	
	}

}
