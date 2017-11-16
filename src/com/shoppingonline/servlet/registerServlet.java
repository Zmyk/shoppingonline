package com.shoppingonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shoppingonline.dao.UserTableDao;
import com.shoppingonline.entity.UserTable;


public class registerServlet extends HttpServlet {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String tel=request.getParameter("tel");
		UserTable user = new UserTable();
		user.setUserName(username);
		user.setUserpassword(password);
		user.setUserTel(tel);
		if(UserTableDao.register(user)){
			response.sendRedirect("login.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
