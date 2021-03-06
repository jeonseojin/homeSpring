package kr.green.springz.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springz.dao.BoardDao;
import kr.green.springz.pagination.Criteria;
import kr.green.springz.pagination.PageMaker;
import kr.green.springz.vo.BoardVo;
import kr.green.springz.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDao boardDao;

	//게시판에 저장되어 있는 모든 정보
	@Override
	public BoardVo getBoard(Integer num) {
		if(num==null) return null;
		return boardDao.getBoard(num);
	}
	//게시판에 저장되어 있는 글을 전부 저장해 놓는 것
	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		return boardDao.getBoardList(cri);
	}
	
	//페이지네이션 설정하기 위함
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
		if(board!=null) {
			board.setViews(board.getViews()+1);
			boardDao.updateBoard(board);//조회수를 증가시켜주기위해서 업데이트를 통해서 사용하기
		}
		return board;
	}
	//게시글 등록
	@Override
	public void insertBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}
	//변경된 내용으로 수정
	@Override
	public void updateBoard(BoardVo board) {
		board.setIsDel('N');
		boardDao.updateBoard(board);
	}
	//게시글 삭제
	@Override
	public void deleteBoard(Integer num, UserVo user) {
		BoardVo board = boardDao.getBoard(num);
		if(board==null)
			return;
		if(!board.getWriter().equals(user.getId()))
			return;
		board.setIsDel('Y');
		board.setDelDate(new Date());
		boardDao.updateBoard(board);
	}
	//좋아요 증가
	@Override
	public int updateUp(int num, String id) {
		if(boardDao.selectUp(num,id)!=0) return -1;//일치하는 값이 있는지 검색 이미 추천한 경우 -1 리턴
		boardDao.insertUp(num,id);// 추천 등록
		boardDao.updateBoardByUp(num);//게시글의 추천만 업뎃
		BoardVo board = boardDao.getBoard(num);
		return board.getUp();
	}
	
}
