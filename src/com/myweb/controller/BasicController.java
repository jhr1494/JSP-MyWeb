package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.service.BoardService;
import com.myweb.board.service.ContentServiceImpl;
import com.myweb.board.service.DeleteServiceImpl;
import com.myweb.board.service.GetListServiceImpl;
import com.myweb.board.service.RegistServiceImpl;
import com.myweb.board.service.UpHitServiceImpl;
import com.myweb.board.service.UpdateServiceImpl;

//1. 확장자 패턴 변경
@WebServlet("*.board")
public class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BasicController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}
	
	protected void dispatchServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); 
		
		//2. 요청분기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		
		String commend = uri.substring(conPath.length()); 
		
		System.out.println(commend);
		
		//★★★★★★
		//MVC2에서는 기본적으로 forward로 이동하고 다시 Controller로 태울때는  Redirect를 사용한다 
		
		//service 부모타입 선언
		BoardService service;

		//3. 요청별 경로지정
		if(commend.equals("/board/list.board")) { //글 목록 요청
			//서블릿 경로가 이미 board이기 때문에 
			//jsp페이지파일이 같은 파일내에 있으면 경로를 생략하면 된다
			service = new GetListServiceImpl();
			service.execute(request, response);
			
			//담긴 리스트를 가지고 forward이동
			request.getRequestDispatcher("board_list.jsp").forward(request, response);
			
		/*
		if(commend.equals("/list.board")) { 
			//서블릿 경로가 폴더경로까지 안되어 있으므로
			//jsp페이지파일의 경로를 꼭 넣어주어야 한다
			response.sendRedirect("/board/board_list.jsp");
		}
		 */

		
		}else if(commend.equals("/board/write.board")) { //작성화면 요청
			request.getRequestDispatcher("board_write.jsp").forward(request, response);
		
		}else if(commend.equals("/board/regist.board")) { //글 등록 요청
			
			service = new RegistServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.board");//다시 컨트롤러를 태워보내는 방식
		}else if(commend.equals("/board/content.board")) { //상세보기 이동
			//조회수 관련작업
			service = new UpHitServiceImpl();
			service.execute(request, response);
			
			service = new ContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("board_content.jsp").forward(request, response);
			
		}else if(commend.equals("/board/modify.board")) { //수정화면 요청
			
			/*
			 * 1. ContentServiceImpl() 재활용합니다
			 * 2. 포워드 형식으로 board_modify.jsp로 이동
			 * 3. 화면에서는 태그안에 데이터값을 출력
			 */
			
			service = new ContentServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("board_modify.jsp").forward(request, response);
			
		}else if(commend.equals("/board/delete.board")) {//글 삭제요청
			
			/*
			 * 1. 화면에서 delete.board요청으로 필요한 값을 get방식으로 넘겨줍니다
			 * 2. DeleteServiceImpl() 생성하고 dao의 delete()메서드로 실행 
			 * 3. 삭제 진행후에 목록페이지로 이동.
			 */
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("list.board");

		}else if(commend.equals("/board/update.board")) {//글 수정 확인

			
			/*
			 * 1.UpdateServiceImpl()을 생성하고 execute()메서드 실행
			 * 2. 서비스에서 bno, title, content를 받아서 DAO의 update()메서드 실행
			 * 3. update()는 sql문으로 수정을 진행
			 * 4. 컨트롤러 에서는 페이지 이동을 content화면으로 이동
			 * 
			 */
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			//contnet화면으로(ans)
			response.sendRedirect("content.board?bno=" + request.getParameter("bno"));
			//request.getRequestDispatcher("board_content.jsp").forward(request, response);
			
		}
		
		
	}

}
