package com.shoppingonline.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.GoodsTypeDao;
import com.shoppingonline.entity.GoodsType;

/**
 * Servlet implementation class adaddGoodsServlet
 */
@WebServlet("/adGetGoodsTypeServlet")
public class adAddNewGoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		System.out.println(request.getSession().getAttribute("admin"));
		if (request.getSession().getAttribute("admin") != null) {
			ArrayList<GoodsType> goodsTypeList = GoodsTypeDao.getAllGoodsType();
			request.setAttribute("goodsTypeList", goodsTypeList);
			request.getRequestDispatcher("adaddGoods.jsp").forward(request, response);
		}
		else
			response.sendRedirect("adlogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
