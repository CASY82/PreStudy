package com.hanghae.demo.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanghae.demo.infrastructure.jpa.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
