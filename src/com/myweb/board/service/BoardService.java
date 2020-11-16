package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	
	//추상메서드 매개변수로 (request, response를 받음)
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
