package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class UpdateServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//수정에 필요한 객체 받기
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
	
		//DAO객체생성, 수정 메서드 실행
		BoardDAO dao = BoardDAO.getInstance();
		
		//update()의  getContent()메서드를 통한 객체 생성
		//BoardVO vo = dao. update(bno, title, content); 
		//request.setAttribute("vo", vo);
		
		dao. update(bno, title, content); //ans
		
		
		
		
		
	}

}
