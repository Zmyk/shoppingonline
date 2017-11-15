package com.shoppingonline.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dao.MyShoppingCarInfoDao;
import com.shopping.entity.MyShoppingCarInfo;


@WebServlet("/toMyShoppingCarServlet")
public class toMyShoppingCarServlet extends HttpServlet {
       
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("gb2312");
		if(request.getSession().getAttribute("loginUser")!=null){
			int sumpay = 0;
			ArrayList<MyShoppingCarInfo> myShoppingCarInfoList = MyShoppingCarInfoDao.getMyShoppingCarInfo(request);
			request.setAttribute("myShoppingCarInfoList", myShoppingCarInfoList);
			for(int i=0;i<myShoppingCarInfoList.size();i++){
				sumpay = sumpay + myShoppingCarInfoList.get(i).getSc().getSumPrice();
			}
			request.setAttribute("sumpay", sumpay);
			request.getRequestDispatcher("myShoppingCarInfo.jsp").forward(request, response);
		}
		else
			response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
