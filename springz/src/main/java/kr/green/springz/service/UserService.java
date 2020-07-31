package kr.green.springz.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.springz.vo.UserVo;

public interface UserService {

	UserVo getUser(String id);

	UserVo isUser(UserVo user);

	UserVo getUser(HttpServletRequest r);

	boolean signup(UserVo user);


}
