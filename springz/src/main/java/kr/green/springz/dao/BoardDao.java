package kr.green.springz.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springz.pagination.Criteria;
import kr.green.springz.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList(@Param("cri")Criteria cri);

	int getTotalCountByBoard(@Param("cri")Criteria cri);

	BoardVo getBoard(@Param("num")Integer num);

	void updateBoard(@Param("board")BoardVo board);

	void insertBoard(@Param("board")BoardVo board);

	int selectUp(@Param("boNum")int num, @Param("id")String id);

	void insertUp(@Param("boNum")int num, @Param("id")String id);

	void updateBoardByUp(@Param("num")int num);

}
