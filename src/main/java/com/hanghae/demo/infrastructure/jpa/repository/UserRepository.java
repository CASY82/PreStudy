package com.hanghae.demo.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanghae.demo.infrastructure.jpa.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
