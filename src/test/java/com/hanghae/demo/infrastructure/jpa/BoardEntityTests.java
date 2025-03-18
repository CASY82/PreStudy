package com.hanghae.demo.infrastructure.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hanghae.demo.infrastructure.jpa.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardEntityTests {
	
	@Autowired
	private BoardRepository repository;
	
	@Test
	public void jpaTest() {
		log.info(this.repository.findAll().toString());
		log.info(this.repository.findById(1L).toString());
	}
}
