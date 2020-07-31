package kr.green.springz.service;

import java.util.ArrayList;

import kr.green.springz.pagination.Criteria;
import kr.green.springz.pagination.PageMaker;
import kr.green.springz.vo.BoardVo;
import kr.green.springz.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	PageMaker getPageMakerByBoard(Criteria cri);

	BoardVo getBoard(Integer num);

	BoardVo view(Integer num);

	void insertBoard(BoardVo board);

	void updateBoard(BoardVo board);

	void deleteBoard(Integer num, UserVo user);
}
