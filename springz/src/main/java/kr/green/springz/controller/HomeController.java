package kr.green.springz.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		System.out.println(dbUser);
		return mv;
	}

	
	
}
