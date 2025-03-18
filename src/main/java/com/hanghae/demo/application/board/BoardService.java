package com.hanghae.demo.application.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanghae.demo.application.board.obj.BoardDataObject;
import com.hanghae.demo.domain.board.Board;
import com.hanghae.demo.domain.board.BoardDomainRepository;
import com.hanghae.demo.domain.board.BoardFactory;
import com.hanghae.demo.domain.board.impl.BoardDomainJpaRepository;
import com.hanghae.demo.domain.user.UserId;
import com.hanghae.demo.infrastructure.jpa.repository.BoardRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository jpaRepository;
	private BoardDomainRepository repository;
	private BoardFactory factory;
	
	@PostConstruct
	private void init() {
		this.repository = new BoardDomainJpaRepository(this.jpaRepository);
		this.factory = new BoardFactory();
	}
	
	//게시글 작성 및 수정
	public void writeBoard(BoardDataObject data) {
		Board write = this.factory.getInstance();
		
		write.setTitle(data.getTitle());
		write.setContent(data.getContent());
		write.setUserId(UserId.of(data.getUserId()));
		write.setPassword(data.getPassword());
		
		this.repository.save(write);
	}
	
	//게시글 조회
	public Board getBoard(Long id) {
		return this.repository.selectBoardById(id);
	}
	
	//게시글 리스트
	public List<Board> getList() {
		return this.repository.getBoardList();
	}
	
	//게시글 삭제
	public void deleteBoard(Long id) {
		this.repository.delete(id);
	}
}
