package com.hanghae.demo.domain.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class UserId {
	private final String value;
}
