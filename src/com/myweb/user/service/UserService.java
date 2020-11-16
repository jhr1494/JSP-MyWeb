package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

	public int execute(HttpServletRequest request, HttpServletResponse response);
}
