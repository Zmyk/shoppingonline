package com.shoppingonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.GoodsTypeDao;
import com.shoppingonline.entity.GoodsType;

/**
 * Servlet implementation class adAddNewGoodsTypeServlet
 */
@WebServlet("/adAddNewGoodsTypeServlet")
public class adAddNewGoodsTypeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			String type = request.getParameter("typeName");
			GoodsType gt = new GoodsType();
			gt.setType(type);
			GoodsTypeDao.addNewGoodType(gt);
			response.sendRedirect("toHandleGoodsTypeServlet");
		}
		else
			response.sendRedirect("adlogin.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
