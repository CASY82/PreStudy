package com.hanghae.demo.domain.board;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class BoardId {
	private final Long value;
	
	static BoardId of(int value) { return BoardId.of((long) value); }
	
	@Override
	public String toString() {
		return Long.toString(this.value);
	}
}
