package kr.green.springz.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.springz.vo.UserVo;

public interface UserDao {

	public UserVo getUser(@Param("id")String id);
}
