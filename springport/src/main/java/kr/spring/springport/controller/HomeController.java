package kr.spring.springport.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.springport.service.UserService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired
//	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		logger.info("URI:/home/GET");
		mv.setViewName("/main/home");
		return mv;
	}
	
	@RequestMapping(value = "/main/signin", method = RequestMethod.GET)
	public ModelAndView signin(ModelAndView mv) {
		logger.info("URI:/signin/GET");
		mv.setViewName("/main/signin");
		return mv;
	}
	
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		logger.info("URI:/board/list/GET");
		mv.setViewName("/board/list");
		return mv;
	}
	
}
