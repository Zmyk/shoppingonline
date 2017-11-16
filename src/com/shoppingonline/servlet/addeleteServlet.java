package com.shoppingonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.GoodsDao;

@WebServlet("/addeleteServlet")
public class addeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			int goodsid = Integer.valueOf(request.getParameter("goodsid"));
			GoodsDao.deleteGoods(goodsid);
			response.sendRedirect("adloginServlet");
		}
		else
			response.sendRedirect("login.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
