package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class DeleteServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		
		//DAO객체
		BoardDAO dao = BoardDAO.getInstance();
		dao.delete(bno);

	}

}
