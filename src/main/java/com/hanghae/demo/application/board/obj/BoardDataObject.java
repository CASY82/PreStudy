package com.hanghae.demo.application.board.obj;

import lombok.Data;

@Data
public class BoardDataObject {
	private String userId;
	private String title;
	private String content;
	private String password;
}
