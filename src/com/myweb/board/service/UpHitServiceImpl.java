package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class UpHitServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		
		
		
		//화면에서 넘어온 쿠키를 받아서, 현재 조회번호와 같은지 검사해서 실행여부 결정
		Cookie[] arr = request.getCookies();
		boolean flag = true;
		
		if(arr != null) {
			for(Cookie c : arr) {
				
				//쿠키이름이 게시글 도회번호와 동일한지 검사
				if(c.getName().equals(bno)) { //현재 조회번호와 중복O -- 동일작업
					flag = false; //중복O
					break;
				}
			}//end for
		}//end if
		
		if(flag) {//중복X
			
			BoardDAO dao = BoardDAO.getInstance();
			dao.upHit(bno); //조회수 증가 메서드 --- 무분별한 조회수 등가를 방지하기 위해 Cookie를 사용하여 중복증가를 제재
		}
		
		
		//쿠키를 이용해서 마지막 조회된 번호를 클라이언트 측으로 전달
		Cookie cookie = new Cookie(bno, bno); //쿠키형식: 1:1, 2:2, 3:3
		cookie.setMaxAge(30);//만료시간 설정
		response.addCookie(cookie);//쿠키보내기
		
		
		

	}

}
