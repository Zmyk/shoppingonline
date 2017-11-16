package com.shoppingonline.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.ShoppingCarDao;
import com.shoppingonline.entity.Goods;
import com.shoppingonline.entity.ShoppingCar;
import com.shoppingonline.entity.UserTable;

/**
 * Servlet implementation class addToShoppingCarServlet
 */
@WebServlet("/addToShoppingCarServlet")
public class addToShoppingCarServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("loginUser") != null) {
			int goodsID = Integer.valueOf(request.getParameter("goodsid").toString());
			int userID = ((UserTable)request.getSession().getAttribute("loginUser")).getUserID();
			Goods g = new Goods();
			g.setGoodsID(goodsID);
			int goodsNum = ShoppingCarDao.getTheGoodsNum(g);
			ShoppingCar sc = new ShoppingCar();
			sc.setGoodsID(goodsID);
			sc.setGoodsNum(goodsNum+1);
			sc.setUserID(userID);
			int sumPrice = ShoppingCarDao.getSumPrice(sc);
			sc.setSumPrice(sumPrice);
			if(goodsNum==0){
				ShoppingCarDao.addToShoppingCar(sc);
			}
			else{
				ShoppingCarDao.updateToShoppingCar(sc);
			}
			request.getRequestDispatcher("loginServlet").forward(request, response);
		}
		else
			response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
