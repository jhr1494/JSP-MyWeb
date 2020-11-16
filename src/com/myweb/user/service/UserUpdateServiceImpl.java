package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserUpdateServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		UserVO vo = new UserVO(id, pw, name, email, address, null);
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.update(vo); //성공시 1, 실패시 0
		
		return result;
		
	}

}
