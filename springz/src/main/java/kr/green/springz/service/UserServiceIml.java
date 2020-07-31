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

	@Override
	public boolean signup(UserVo user) {
		if(user==null) return false;
		//중복 또는 공백인 경우 false
		if(userDao.getUser(user.getId())!=null|| user.getId().length()==0)//아이디
			return false;
		if(user.getPw()==null|| user.getPw().length()==0)//비밀번호
			return false;
		if(user.getEmail()==null || user.getEmail().length()==0 || !user.getEmail().contains("@"))//이메일(추가로 @가 빠진 경우)
			return false;
		if(user.getGender()==null|| user.getGender().length()==0)//성별
			user.setGender("mail");//성별을 선택하지 않은 경우 mail이 기본으로 들어옴
		user.setAuth("USER");
		user.setIsDel("N");
		
		//비밀번호 암호화 진행
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		userDao.insertUser(user);
		return true;
	}


}
