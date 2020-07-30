package kr.green.springz.service;

import java.util.ArrayList;

import kr.green.springz.pagination.Criteria;
import kr.green.springz.pagination.PageMaker;
import kr.green.springz.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	PageMaker getPageMakerByBoard(Criteria cri);

	BoardVo getBoard(Integer num);

	BoardVo view(Integer num);

}
