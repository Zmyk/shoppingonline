package com.shoppingonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shoppingonline.entity.Goods;
import com.shoppingonline.entity.GoodsType;
import com.shoppingonline.util.DBConnect;

public class GoodsTypeDao {
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	private static ArrayList<GoodsType> list;
	
	public static boolean isTypeExist(GoodsType gt){
		String sql = "select * from GoodsType where type=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, gt.getType());
			rs = stmt.executeQuery();
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
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
		return false;
	}
	
	public static void addNewGoodType(GoodsType gt){
		if(!GoodsTypeDao.isTypeExist(gt)){
			String sql = "insert into GoodsType(type) values (?)";
			try {
				con = DBConnect.getConnection();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, gt.getType());
				stmt.executeUpdate();
			} catch (SQLException e) {
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
		}
		
	}
	public static int getTypeIdByType(GoodsType g){
		int goodsTypeId = 0;
		String goodsType = g.getType();
		String sql = "select typeid from GoodsType where Type=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, goodsType);
			rs = stmt.executeQuery();
			while(rs.next()){
				goodsTypeId = rs.getInt("typeid");
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
		return goodsTypeId;
		
	}
	
	
	
	public static ArrayList<GoodsType> getAllGoodsType(){
		list = new ArrayList<GoodsType>();
		String sql = "select * from GoodsType";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				GoodsType gt = new GoodsType();
				gt.setType(rs.getString("type"));
				gt.setTypeID(rs.getInt("typeid"));
				list.add(gt);
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
	public static String getTypeByTypeID(GoodsType gt) {
		String type = new String();
		int typeid = gt.getTypeID();
		String sql = "select type from GoodsType where typeid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, typeid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				type = rs.getString("type");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return type;
	}
	
	public static String getGoodsTypeName(Goods g) {
		String goodsTypeName = new String();
		int TypeId = g.getTypeID();
		String sql = "select type from GoodsType where TypeID=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, TypeId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				goodsTypeName = rs.getString("type");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return goodsTypeName;
	}

	public static void deleteGoodsTypeByTypeID(GoodsType gt) {
		String sql = "delete from goodstype where typeid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, gt.getTypeID());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
