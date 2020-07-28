package kr.spring.springport.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.spring.springport.dao.UserDao;

public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userDao;
}
