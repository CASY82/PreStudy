package com.hanghae.demo.domain.board.impl;

import java.util.List;

import org.springframework.util.Assert;

import com.hanghae.demo.domain.board.Board;
import com.hanghae.demo.domain.board.BoardDomainRepository;
import com.hanghae.demo.domain.board.BoardId;
import com.hanghae.demo.domain.user.UserId;
import com.hanghae.demo.infrastructure.jpa.entity.BoardEntity;
import com.hanghae.demo.infrastructure.jpa.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDomainJpaRepository implements BoardDomainRepository {

	private final BoardRepository jpaRepository;
	
	@Override
	public List<Board> getBoardList() {
		return this.jpaRepository.findAll().stream()
				.map(this::entityConvert)
				.toList();
	}

	@Override
	public Board selectBoardById(Long id) {
		return this.entityConvert(this.jpaRepository.findById(id).orElse(null));
	}

	@Override
	public void delete(Long id) {
		this.jpaRepository.deleteById(id);
	}

	@Override
	public void save(Board obj) {
		this.jpaRepository.save(this.domainConvert(obj));
	}
	
	private Board entityConvert(BoardEntity entity) {
		Board obj = new Board();
		
		Assert.isNull(entity, "Entity는 null일 수 없습니다.");
		
		obj.setId(BoardId.of(entity.getId()));
		obj.setUserId(UserId.of(entity.getUserId()));
		obj.setTitle(entity.getTitle());
		obj.setContent(entity.getContent());
		obj.setPassword(entity.getPassword());
		obj.setCreatedAt(entity.getCreatedAt().toInstant());
		obj.setUpdatedAt(entity.getUpdatedAt().toInstant());
		
		return obj;
	}
	
	private BoardEntity domainConvert(Board obj) {
		BoardEntity entity = new BoardEntity();
		
		Assert.notNull(obj, "Board 객체는 null일 수 없습니다.");
	    
	    entity.setId(obj.getId().getValue()); // BoardId에서 ID 값을 가져와 설정
	    entity.setUserId(obj.getUserId().getValue()); // UserId에서 사용자 ID 값을 가져와 설정
	    entity.setTitle(obj.getTitle());
	    entity.setContent(obj.getContent());
	    entity.setPassword(obj.getPassword());
		
		return entity;
	}

}
