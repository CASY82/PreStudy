package com.hanghae.demo.domain.user;

import com.hanghae.demo.domain.common.DomainEntity;
import com.hanghae.demo.domain.user.auth.Auth;

import lombok.Data;

@Data
@DomainEntity
public class User {
	private Long id;
	private UserId userId;
	private String password;
	private String name;
	private Auth auth;
	
	
}
