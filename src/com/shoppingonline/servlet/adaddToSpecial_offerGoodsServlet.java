package com.shoppingonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.GoodsDao;
import com.shoppingonline.entity.Goods;

/**
 * Servlet implementation class adaddToSpecial_offerGoodsServlet
 */
@WebServlet("/adaddToSpecial_offerGoodsServlet")
public class adaddToSpecial_offerGoodsServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			float rank = Float.valueOf(request.getParameter("rank"));
			System.out.println(rank);
			int goodsid = Integer.valueOf(request.getParameter("goodsid"));
			Goods g = new Goods();
			g.setGoodsID(goodsid);
			GoodsDao.addToSpecial_offerGoods(g,rank);
			response.sendRedirect("adloginServlet");
		}
		else
			response.sendRedirect("adlogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
