package com.shoppingonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shoppingonline.entity.Goods;
import com.shoppingonline.util.DBConnect;

public class GoodsDao {

	private static ArrayList<Goods> list;
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;

	public static ArrayList<Goods> getSpecial_offerGoods() {
		list = new ArrayList<Goods>();
		String sql = "select * from Goods where special_offer='true'";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Goods good = new Goods();
				good.setGoodsID(rs.getInt("goodsID"));
				good.setGoodsName(rs.getString("goodsName"));
				good.setPrice(rs.getInt("price"));
				good.setTypeID(rs.getInt("typeID"));
				good.setGoodsNum(rs.getInt("goodsnum"));
				good.setSpecial_price(rs.getInt("special_price"));
				list.add(good);
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
		return list;
	}

	public static ArrayList<Goods> getIsnotSpecial_offerGoods() {
		list = new ArrayList<Goods>();
		String sql = "select * from Goods where special_offer='false'";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Goods good = new Goods();
				good.setGoodsID(rs.getInt("goodsID"));
				good.setGoodsName(rs.getString("goodsName"));
				good.setPrice(rs.getInt("price"));
				good.setTypeID(rs.getInt("typeID"));
				good.setGoodsNum(rs.getInt("goodsnum"));
				list.add(good);
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
		return list;
	}

	public static int getTypeId(Goods g) {
		int typeid = 0;
		int goodsid = g.getGoodsID();
		String sql = "select typeid from goods where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, goodsid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				typeid = rs.getInt("typeid");
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
		return typeid;
	}

	public static void addGoods(Goods g) {
		String sql = "insert into goods(typeid,goodsname,price,goodsnum) values(?,?,?,?)";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, g.getTypeID());
			stmt.setString(2, g.getGoodsName());
			stmt.setInt(3, g.getPrice());
			stmt.setInt(4, g.getGoodsNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void deleteGoods(int goodsid) {
		String sql = "delete from goods where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, goodsid);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getGoodsName(Goods g) {
		String goodsName = new String();
		int goodsid = g.getGoodsID();
		String sql = "select goodsname from goods where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, goodsid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				goodsName = rs.getString("goodsname");
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
		return goodsName;

	}

	public static int getPrice(Goods g) {
		int price = 0;
		int goodsid = g.getGoodsID();
		String sql = "select price from goods where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, goodsid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				price = rs.getInt("price");
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

		return price;

	}

	public static int getGoodsNum(Goods g) {
		String sql = "select goodsnum from goods where goodsid=?";
		int goodsNum = 0;
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, g.getGoodsID());
			rs = stmt.executeQuery();
			while (rs.next()) {
				goodsNum = rs.getInt("goodsnum");
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
		return goodsNum;
	}

	public static boolean isSpecial_offer(Goods g) {
		String sql = "select * from goods where goodsid=? and special_offer='true'";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, g.getGoodsID());
			rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
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
		return false;
	}

	public static void addToSpecial_offerGoods(Goods g,float rank) {
		if (!GoodsDao.isSpecial_offer(g)) {
			int speical_price = (int)(GoodsDao.getPrice(g)*rank);
			String sql = "Update goods set special_offer='true',special_price=? where goodsid=?";
			try {
				con = DBConnect.getConnection();
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, speical_price);
				stmt.setInt(2, g.getGoodsID());
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void removeSpecial_offerGoods(Goods g) {
		String sql = "Update goods set special_offer='false',special_price=0 where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, g.getGoodsID());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static int getspecial_price(Goods g) {
		int special_price = 0;
		String sql = "select special_price from goods where goodsid=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, g.getGoodsID());
			rs = stmt.executeQuery();
			while (rs.next()) {
				special_price = rs.getInt("special_price");
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

		return special_price;
	}

}
