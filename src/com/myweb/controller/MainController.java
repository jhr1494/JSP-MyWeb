package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.main.service.MainService;



@WebServlet("*.main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void dispatchServlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		
		String commend = uri.substring(conPath.length()); 
		
		System.out.println(commend);
		
		MainService service;
		
		//if
		
	}

}
