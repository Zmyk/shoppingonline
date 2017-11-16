package com.shoppingonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.shoppingonline.entity.Goods;
import com.shoppingonline.entity.ShoppingCar;
import com.shoppingonline.entity.UserTable;
import com.shoppingonline.util.DBConnect;

public class ShoppingCarDao {
	private static ArrayList<ShoppingCar> list;
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public static ArrayList<ShoppingCar> getMyShoppingCar(HttpServletRequest request) {
		String sql = "select * from shoppingCar where userID=?";
		UserTable user = (UserTable) request.getSession().getAttribute("loginUser");
		int userID = user.getUserID();
		list = new ArrayList<ShoppingCar>();
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, userID);
			rs = stmt.executeQuery();
			while(rs.next()){
				ShoppingCar sc = new ShoppingCar();
				sc.setGoodsID(rs.getInt("goodsID"));
				sc.setGoodsNum(rs.getInt("goodsNum"));
				sc.setUserID(rs.getInt("userid"));
				sc.setSumPrice(rs.getInt("sumprice"));
				list.add(sc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static int getTheGoodsNum(Goods g){
		int goodsNum = 0;
		int goodsId = g.getGoodsID();
		String sql = "select goodsnum from shoppingcar where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, goodsId);
			rs = stmt.executeQuery();
			while(rs.next()){
				goodsNum = goodsNum + rs.getInt("goodsNum");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return goodsNum;
		
	}
	public static int getSumPrice(ShoppingCar sc){
		Goods g = new Goods();
		int sumprice = 0;
		g.setGoodsID(sc.getGoodsID());
		if(GoodsDao.isSpecial_offer(g)){
			sumprice = sc.getGoodsNum()*GoodsDao.getspecial_price(g);
		}else{
			sumprice = sc.getGoodsNum()*GoodsDao.getPrice(g);
		}
		return sumprice;
	}
	
	public static void addToShoppingCar(ShoppingCar sc){
		String sql = "insert into shoppingcar(userid,goodsid,goodsnum,sumprice) values(?,?,?,?)";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, sc.getUserID());
			stmt.setInt(2, sc.getGoodsID());
			stmt.setInt(3, 1);
			stmt.setInt(4, sc.getSumPrice());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateToShoppingCar(ShoppingCar sc){
		String sql = "update shoppingcar set goodsnum=?,sumprice=? where goodsid=?";
		Goods g = new Goods();
		g.setGoodsID(sc.getGoodsID());
		int goodsNum = GoodsDao.getGoodsNum(g);
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, sc.getGoodsNum());
			stmt.setInt(2, sc.getSumPrice());
			stmt.setInt(3, sc.getGoodsID());
			if(sc.getGoodsNum()<=goodsNum){
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteAllShoppingCar() {
		String sql = "delete from shoppingcar";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void deleteShoppingCar(ShoppingCar sc) {
		String sql = "delete from shoppingcar where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, sc.getGoodsID());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
