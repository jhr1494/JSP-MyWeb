package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.myweb.user.model.UserDAO;
import com.myweb.user.model.UserVO;

public class UserLoginServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");		
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.login(id, pw);
		
		if(user != null) { //로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return 1;
		} else { //로그인 실패
			return 0;		
		
			
		}
				
		
	}

}
