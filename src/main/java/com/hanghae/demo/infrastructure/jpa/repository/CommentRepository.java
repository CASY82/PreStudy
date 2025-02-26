package com.hanghae.demo.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanghae.demo.infrastructure.jpa.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
