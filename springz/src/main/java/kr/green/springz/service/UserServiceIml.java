package kr.green.springz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springz.dao.UserDao;
import kr.green.springz.vo.UserVo;

@Service
public class UserServiceIml implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}


}
