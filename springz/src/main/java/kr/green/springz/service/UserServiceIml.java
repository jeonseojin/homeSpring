package kr.green.springz.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springz.dao.UserDao;
import kr.green.springz.vo.UserVo;

@Service
public class UserServiceIml implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public UserVo isUser(UserVo user) {
		UserVo dbUser = userDao.getUser(user.getId());
		if(dbUser!=null && passwordEncoder.matches(user.getPw(), dbUser.getPw())) {
			return dbUser;
		}
		return null;
	}

	@Override
	public UserVo getUser(HttpServletRequest r) {
		return (UserVo)r.getSession().getAttribute("user");
	}


}
