package com.hanghae.demo.domain.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFactory {
	public User getInstance() { return new User(); }
}
