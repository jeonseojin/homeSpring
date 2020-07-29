package kr.green.springz.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springz.service.BoardService;
import kr.green.springz.vo.BoardVo;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardService boardService;
	
	//게시판에 연결
	@RequestMapping(value= "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListG(ModelAndView mv){
		logger.info("URI:/board/list:GET");
	    mv.setViewName("/board/list");
	    ArrayList<BoardVo> list;
	    list = boardService.getBoardList();
	    mv.addObject("list", list);
	    return mv;
	}
}
