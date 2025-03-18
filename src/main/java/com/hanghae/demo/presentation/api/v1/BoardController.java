package com.hanghae.demo.presentation.api.v1;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanghae.demo.application.board.BoardService;
import com.hanghae.demo.application.board.obj.BoardDataObject;
import com.hanghae.demo.domain.board.Board;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	/**
	 * 게시글 작성 및 수정
	 * @return
	 */
	@PostMapping("/write")
	public ResponseEntity<String> write(@Valid @RequestBody BoardDataObject data) {
		try {
			this.service.writeBoard(data);
		} catch(Exception ex) { // Global Exception으로 분리할 것
			log.error("Error", ex);
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	/**
	 * 게시글 리스트 반환
	 * @return
	 */
	@GetMapping("/list")
	public ResponseEntity<List<Board>> getBoardList() {
		try {
			return new ResponseEntity<>(this.service.getList(), HttpStatusCode.valueOf(200));
		} catch(Exception ex) {
			log.error("Error", ex);
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}
	
	/**
	 * 게시글 1개 반환
	 * @param id
	 * @return
	 */
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> getBoardData(@PathVariable("id") String id) {
		try {
			if (StringUtils.isNumeric(id)) {
                return new ResponseEntity<>(this.service.getBoard(Long.valueOf(id)), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
		} catch(Exception ex) {
			log.error("Error", ex);
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}
}
