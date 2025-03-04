package com.hanghae.demo.domain.board;

import java.util.List;

public interface BoardDomainRepository {
	List<Board> getBoardList();
	Board selectBoardById(Long id);
	void delete(Long id);
	void save(Board obj);
}
