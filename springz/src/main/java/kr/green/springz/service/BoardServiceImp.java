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
}
