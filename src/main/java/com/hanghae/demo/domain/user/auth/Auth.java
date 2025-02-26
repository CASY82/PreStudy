package com.hanghae.demo.domain.user.auth;

public enum Auth {
	USER("user", "U"),
	ADMIN("admin", "A")
	;
	
	Auth(String description, String code) {
		this.description = description;
		this.code = code;
	}
	
	private String description;
	private String code;
	
	public static Auth valueOfCode(Integer code) {
		for(Auth auth : values()) {
			if(auth.code.equals(code)) {
				return auth;
			}
		}
		throw new IllegalArgumentException("코드가 일치하지 않습니다.");
	}
	
	public String getCode() {
		return this.code;
	} 
}
