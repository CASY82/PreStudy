package com.hanghae.demo.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanghae.demo.infrastructure.jpa.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	Optional<BoardEntity> findById(Long id);
}
