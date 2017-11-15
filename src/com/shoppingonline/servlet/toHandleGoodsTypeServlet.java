package com.shoppingonline.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.GoodsTypeDao;
import com.shopping.entity.GoodsType;

/**
 * Servlet implementation class adAddNewGoodsTypeServlet
 */
@WebServlet("/toHandleGoodsTypeServlet")
public class toHandleGoodsTypeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			ArrayList<GoodsType> goodsTypeList = GoodsTypeDao.getAllGoodsType();
			request.setAttribute("goodsTypeList", goodsTypeList);
			request.getRequestDispatcher("adHandleGoodsType.jsp").forward(request, response);
		}
		else
			response.sendRedirect("adlogin.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
