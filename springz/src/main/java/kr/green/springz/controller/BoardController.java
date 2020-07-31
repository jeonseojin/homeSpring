package kr.green.springz.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springz.pagination.Criteria;
import kr.green.springz.pagination.PageMaker;
import kr.green.springz.service.BoardService;
import kr.green.springz.service.UserService;
import kr.green.springz.utils.UploadFileUtils;
import kr.green.springz.vo.BoardVo;
import kr.green.springz.vo.UserVo;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	
	private String uploadPath="D:\\git\\uploadfiles";
	
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
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVo board, HttpServletRequest r, MultipartFile file2) throws IOException, Exception{
		mv.setViewName("redirect:/board/list");
	    board.setWriter(userService.getUser(r).getId());
	    String file = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes());//파일 업로드용
	    board.setFile(file);
	    boardService.insertBoard(board);
	    return mv;
	}
	//파일 다운로드 기능
	@ResponseBody
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{//	필요없는코드        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	    	//객체 생성
	        HttpHeaders headers = new HttpHeaders();
	        //다운로드할 파일을 읽어오기
	        in = new FileInputStream(uploadPath+fileName);
	        // 다운로드 시 저장할 파일명
	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        //헤더에 컨텐츠 타입을 설정
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        //헤더 정보를 추가
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        //REsposeEntity 객체 생성 및 전송할 파일정보,헤더 정보 ,헤더 상태
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	// 게시물 수정화면
	@RequestMapping(value= "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, HttpServletRequest r){
		logger.info("URI:/board/modify:GET");
	    mv.setViewName("/board/modify");
	    BoardVo board = boardService.getBoard(num);
	    UserVo user = userService.getUser(r);
	    if(board == null || !user.getId().equals(board.getWriter()))
	    	mv.setViewName("redirect:/board/list");
	    mv.addObject("board", board);
	    return mv;
	}
	// 게시물 수정 기능
	@RequestMapping(value= "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, HttpServletRequest r,BoardVo board,MultipartFile file2) throws IOException, Exception{
	    mv.setViewName("redirect:/board/list");
	    board.setWriter(userService.getUser(r).getId());
	    if(!file2.getOriginalFilename().equals("")) {
	    	String fileName = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes());
	    	board.setFile(fileName);
	    }else if(board.getFile()==null || board.getFile().equals("")) {
	    	board.setFile(null);
	    }
	    boardService.updateBoard(board);
	    return mv;
	}
	
	//게시글 삭제
		@RequestMapping(value= "/board/delete", method = RequestMethod.GET)
		public ModelAndView boarDelete(ModelAndView mv,Integer num,HttpServletRequest r){
			logger.info("URI:/board/delete:GET");
		    mv.setViewName("redirect:/board/list");
		    boardService.deleteBoard(num, userService.getUser(r));
		    return mv;
		}
	
}
