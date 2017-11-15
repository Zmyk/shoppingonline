package com.shoppingonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.GoodsTypeDao;
import com.shopping.entity.GoodsType;


@WebServlet("/adDeleteGoodsTypeServlet")
public class adDeleteGoodsTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			int typeid = Integer.valueOf(request.getParameter("typeid"));
			GoodsType gt = new GoodsType();
			gt.setTypeID(typeid);
			GoodsTypeDao.deleteGoodsTypeByTypeID(gt);
			response.sendRedirect("toHandleGoodsTypeServlet");
		}
		else
			response.sendRedirect("adlogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
