package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserJoinServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("adress");


		//중복검사
		UserDAO dao = UserDAO.getInstance();
		int result = dao.checkId(id); //중복시1, 중복 x 0

		if(result == 1) { //이미 존재하는 회원
			return 1;
		} else {
			UserVO vo  =new UserVO(id, pw, name, email, address, null);
			dao.join(vo); //성공이라고 가정 
			return 0;
		}

	}

}
