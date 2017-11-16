package com.shoppingonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.AdministorDao;

/**
 * Servlet implementation class adUnLoginservlet
 */
@WebServlet("/adUnLoginservlet")
public class adUnLoginservlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			AdministorDao.doUnLogin(request);
			response.sendRedirect("adlogin.jsp");
		}
		else
			response.sendRedirect("adlogin.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
