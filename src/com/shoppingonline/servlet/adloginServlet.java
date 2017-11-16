package com.shoppingonline.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.AdministorDao;
import com.shoppingonline.dao.GoodsInfoDao;
import com.shoppingonline.entity.Administor;
import com.shoppingonline.entity.GoodsInfo;


@WebServlet("/adloginServlet")
public class adloginServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Administor ad = new Administor();
		ad.setUsername(username);
		ad.setPassword(password);
		if(AdministorDao.adDoLogin(ad,request)||request.getSession().getAttribute("admin")!=null){
			ArrayList<GoodsInfo> goodsInfoList = GoodsInfoDao.getIsnotSpecial_offerGoodsInfo();
			ArrayList<GoodsInfo> special_offerGoodsInfoList = GoodsInfoDao.getSpecial_offerGoodsInfo();
			request.setAttribute("goodsInfoList", goodsInfoList);
			request.setAttribute("special_offerGoodsInfoList", special_offerGoodsInfoList);
			request.getRequestDispatcher("admain.jsp").forward(request, response);
		}
		else
			response.sendRedirect("error.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
