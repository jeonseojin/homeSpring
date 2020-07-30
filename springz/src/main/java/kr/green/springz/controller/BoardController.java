package kr.green.springz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springz.pagination.Criteria;
import kr.green.springz.pagination.PageMaker;
import kr.green.springz.service.BoardService;
import kr.green.springz.service.UserService;
import kr.green.springz.vo.BoardVo;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	
	//게시판에 연결
	@RequestMapping(value= "/board/list", method = RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, Criteria cri){
		logger.info("URI:/board/list:GET");
	    mv.setViewName("/board/list");
	    ArrayList<BoardVo> list= boardService.getBoardList(cri);
	    mv.addObject("list", list);
	    PageMaker pm = boardService.getPageMakerByBoard(cri);
	    mv.addObject("pm", pm);
	    return mv;
	}
	
	//게시글로 연결
	@RequestMapping(value= "/board/detail", method = RequestMethod.GET)
	public ModelAndView detailGet(ModelAndView mv,Integer num, Criteria cri){
		logger.info("URI:/board/detail:GET");
	    mv.setViewName("/board/detail");
	    BoardVo board = boardService.view(num);//조회수설정
	    mv.addObject("board", board);
	    mv.addObject("cri", cri);
	    return mv;
	}
	
	//게시판에서 글쓰기 화면 연결
	@RequestMapping(value= "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv){
		logger.info("URI:/board/register:GET");
	    mv.setViewName("/board/register");
	    return mv;
	}
	//게시판에서 글쓰기 기능 설정
		@RequestMapping(value= "/board/register", method = RequestMethod.POST)
		public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, HttpServletRequest r){
			logger.info("URI:/board/register:POST");
			System.out.println(board);
			mv.setViewName("/board/register");
		    board.setWriter(userService.getUser(r).getId());
		    boardService.insertBoard(board);
		    
		    return mv;
		}
}
