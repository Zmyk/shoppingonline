package com.shoppingonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.ShoppingCarDao;
import com.shoppingonline.entity.ShoppingCar;

/**
 * Servlet implementation class deleteShoppingCarServlet
 */
@WebServlet("/deleteShoppingCarServlet")
public class deleteShoppingCarServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("loginUser") != null) {
			ShoppingCar sc = new ShoppingCar();
			sc.setGoodsID(Integer.valueOf(request.getParameter("goodsid").toString()));
			ShoppingCarDao.deleteShoppingCar(sc);
			request.getRequestDispatcher("toMyShoppingCarServlet").forward(request, response);
		}
		else
			response.sendRedirect("login.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
