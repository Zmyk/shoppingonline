package com.shoppingonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.shoppingonline.entity.UserTable;
import com.shoppingonline.util.DBConnect;

public class UserTableDao {
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;

	public static boolean doLogin(UserTable user, HttpServletRequest request) {
		String checkCode = String.valueOf(request.getSession().getAttribute("CheckCode"));
		if (user.getCheckCode().toLowerCase().equals(checkCode.toLowerCase())) {
			request.getSession().setAttribute("CheckCode", null);
			try {
				String sql = "select * from usertable";
				con = DBConnect.getConnection();
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					if (rs.getString("username").equals(user.getUserName())
							&& rs.getString("userpassword").equals(user.getUserpassword())) {
						UserTable loginUser = new UserTable();
						loginUser.setUserID(rs.getInt("userid"));
						loginUser.setUserName(rs.getString("username"));
						loginUser.setUserpassword(rs.getString("userpassword"));
						loginUser.setUserTel(rs.getString("usertel"));
						request.getSession().setAttribute("loginUser", loginUser);
						return true;
					}
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
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
		return false;
	}

	public static int getuserNum() {
		int userID = 1;
		try {
			String sql1 = "select * from usertable";
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			while (rs.next()) {
				userID++;
			}
		} catch (Exception e) {
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return userID;
	}

	public static boolean isUserexit(UserTable u) {
		String sql = "select username from usertable where username=?";
		try {
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getUserName());
			rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
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

	public static boolean register(UserTable user) {

		if (!UserTableDao.isUserexit(user)) {
			String sql = "insert into UserTable(userName,userPassword,userTel) values (?,?,?)";
			try {
				con = DBConnect.getConnection();
				stmt = con.prepareStatement(sql);
				stmt.setString(1, user.getUserName());
				stmt.setString(2, user.getUserpassword());
				stmt.setString(3, user.getUserTel());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			return true;
		} else {
			return false;
		}
	}

	public static void doUnLogin(HttpServletRequest request) {
		request.getSession().setAttribute("loginUser", null);

	}
}
