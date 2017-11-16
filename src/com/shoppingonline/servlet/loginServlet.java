package com.shoppingonline.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.GoodsInfoDao;
import com.shoppingonline.dao.UserTableDao;
import com.shoppingonline.entity.GoodsInfo;
import com.shoppingonline.entity.UserTable;

public class loginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkcode");
		System.out.println(username == null);
		UserTable user = new UserTable();
		user.setUserName(username);
		user.setUserpassword(password);
		user.setCheckCode(checkCode);
		UserTable loginUser = (UserTable) request.getSession().getAttribute("loginUser");
		if (loginUser == null && username != null && password != null && checkCode != null) {
			if (UserTableDao.doLogin(user, request)) {
				ArrayList<GoodsInfo> goodsInfoList = GoodsInfoDao.getIsnotSpecial_offerGoodsInfo();
				ArrayList<GoodsInfo> special_offerGoodsInfoList = GoodsInfoDao.getSpecial_offerGoodsInfo();
				request.setAttribute("goodsInfoList", goodsInfoList);
				request.setAttribute("special_offerGoodsInfoList", special_offerGoodsInfoList);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				response.sendRedirect("error.jsp");
			}
		}
		else{
			ArrayList<GoodsInfo> goodsInfoList = GoodsInfoDao.getIsnotSpecial_offerGoodsInfo();
			ArrayList<GoodsInfo> special_offerGoodsInfoList = GoodsInfoDao.getSpecial_offerGoodsInfo();
			request.setAttribute("goodsInfoList", goodsInfoList);
			request.setAttribute("special_offerGoodsInfoList", special_offerGoodsInfoList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		

		

	}
}
