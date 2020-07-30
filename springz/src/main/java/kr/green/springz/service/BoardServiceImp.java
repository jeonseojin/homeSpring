package kr.green.springz.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springz.dao.BoardDao;
import kr.green.springz.pagination.Criteria;
import kr.green.springz.pagination.PageMaker;
import kr.green.springz.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDao boardDao;

	@Override
	public BoardVo getBoard(Integer num) {
		if(num==null) return null;
		return boardDao.getBoard(num);
	}
	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}
	
	@Override
	public PageMaker getPageMakerByBoard(Criteria cri) {
		PageMaker pm =new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(boardDao.getTotalCountByBoard(cri));
		return pm;
	}
	
	//조회수 설정
	@Override
	public BoardVo view(Integer num) {
		BoardVo board =getBoard(num);
		board.setViews(board.getViews()+1);
		boardDao.updateBoard(board);//조회수를 증가시켜주기위해서 업데이트를 통해서 사용하기
		return board;
	}
}
