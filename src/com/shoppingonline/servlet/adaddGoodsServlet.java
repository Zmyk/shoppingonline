package com.shoppingonline.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingonline.dao.GoodsDao;
import com.shoppingonline.dao.GoodsTypeDao;
import com.shoppingonline.entity.Goods;
import com.shoppingonline.entity.GoodsType;

/**
 * Servlet implementation class adaddGoodsServlet
 */
@WebServlet("/adaddGoodsServlet")
public class adaddGoodsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		if (request.getSession().getAttribute("admin") != null) {
			String goodsname = request.getParameter("goodsname");
			int price =Integer.valueOf(request.getParameter("price"));
			String type = request.getParameter("type");
			int goodsnum = Integer.valueOf(request.getParameter("goodsnum"));
			GoodsType gt = new GoodsType();
			gt.setType(type);
			int typeID = GoodsTypeDao.getTypeIdByType(gt);
			Goods g = new Goods();
			g.setGoodsName(goodsname);
			g.setGoodsNum(goodsnum);
			g.setPrice(price);
			g.setTypeID(typeID);
			GoodsDao.addGoods(g);
			response.sendRedirect("adloginServlet");
		}
		else
			response.sendRedirect("adlogin.jsp");
	}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
