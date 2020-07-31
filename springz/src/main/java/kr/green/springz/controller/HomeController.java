package kr.green.springz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springz.service.UserService;
import kr.green.springz.vo.UserVo;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv ){
		logger.info("URI:/");
	    mv.setViewName("/main/home");
	    return mv;
	}
	
	//로그인 화면
	@RequestMapping(value= "/main/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv){
		logger.info("URI:/main/signin:GET");
	    mv.setViewName("/main/signin");
	    return mv;
	}
	
	//로그인 관련 동작
	@RequestMapping(value= "/main/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv, UserVo user){
		logger.info("URI:/main/signin");
		UserVo dbUser = userService.isUser(user);
		if(dbUser!=null) {
			mv.setViewName("redirect:/board/list");
			mv.addObject("user", dbUser);
		}else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	//로그아웃
	@RequestMapping(value= "/main/signout", method = RequestMethod.GET)
	public ModelAndView signOut(ModelAndView mv, HttpServletRequest r){
		logger.info("URI:/main/signout:GET");
	    mv.setViewName("redirect:/");
	    r.getSession().removeAttribute("user");
	    return mv;
	}

	//ajax 테스트
	@RequestMapping(value ="/test")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody TestVo test){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    	System.out.println(test);
	    map.put("res","succecc!!");
	    return map;
	}
	
}
class TestVo{
	private String id;
	private int num;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "TestVo [id=" + id + ", num=" + num + "]";
	}
	
}