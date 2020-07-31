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
		logger.info("URI:/signin:GET");
	    mv.setViewName("/main/signin");
	    return mv;
	}
	
	//로그인 관련 동작
	@RequestMapping(value= "/main/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv, UserVo user){
		logger.info("URI:/signin");
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
		logger.info("URI:/signout:GET");
	    mv.setViewName("redirect:/");
	    r.getSession().removeAttribute("user");
	    return mv;
	}
	
	//회원가입 화면 연결
	@RequestMapping(value= "/main/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv){
		logger.info("URI:/signup:GET");
	    mv.setViewName("/main/signup");
	    return mv;
	}
	//회원가입 정보 전송
	@RequestMapping(value= "/main/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo user){
		logger.info("URI:/signup");
		System.out.println(user);
		if(userService.signup(user)) {
			System.out.println(user);
			mv.setViewName("redirect:/");
		}
		else {
			mv.setViewName("redirect:/main/signup");
			System.out.println(user);
			mv.addObject("user", user);
		}
	    return mv;
	}
	//아이디 중복 확인
	@RequestMapping(value ="/idCheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    map.put("res",userService.getUser(id)==null);
	    return map;
	}
}
