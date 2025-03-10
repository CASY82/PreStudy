package com.hanghae.demo.domain.board;

import java.time.Instant;
import java.util.List;

import com.hanghae.demo.domain.common.DomainEntity;
import com.hanghae.demo.domain.user.UserId;

import lombok.Data;

@Data
@DomainEntity
public class Board {
	private BoardId id;
	private UserId userId;
	private String title;
	private String content;
	private String password; // 1회용으로 만들고 제거 예정
	private Instant createdAt;
	private Instant updatedAt;
	
	// 전체 게시글 조회
	public List<Board> getBoardList(BoardDomainRepository repository) {
		return repository.getBoardList();
	}
	
	// 선택한 게시글 조회
	public Board fetchBoard(BoardDomainRepository repository) {
		Board data = repository.selectBoardById(this.id.getValue());
		setUserId(data.getUserId());
		setTitle(data.getTitle());
		setContent(data.getContent());
		setPassword(data.getPassword());
		setCreatedAt(data.getCreatedAt());
		setUpdatedAt(data.getUpdatedAt());
		
		return this;
	}
	
	// 선택한 게시글 저장 / 업데이트
	public void save(BoardDomainRepository repository) {
		repository.save(this);
	}
	
	// 선택한 게시글 삭제
	public void delete(BoardDomainRepository repository, String password) throws Exception {
		if (this.password.equals(password)) {
			repository.delete(this.id.getValue());
		} else {
			throw new Exception("비밀번호가 다릅니다.");
		}
	}
}
