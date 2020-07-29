package kr.green.springz.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv ){
	    mv.setViewName("/main/home");
	    return mv;
	}
	
	//로그인화면
	@RequestMapping(value= "/main/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv){
	    mv.setViewName("/main/signin");
	    return mv;
	}
	
	
}
