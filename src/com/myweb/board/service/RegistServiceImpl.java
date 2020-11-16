package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class RegistServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		System.out.println(writer);
		System.out.println(title);
		System.out.println(content);
		
		//DAO객체생성
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title, content);
	}
	

}
