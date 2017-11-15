package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;

import com.shopping.entity.Administor;
import com.shoppingonline.util.DBConnect;

public class AdministorDao {

	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;



	public static boolean adDoLogin(Administor ad,HttpServletRequest request) {
		try {
			String sql = "select * from Administrator where adName=? and adPassword=?";
			con = DBConnect.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ad.getUsername());
			stmt.setString(2, ad.getPassword());
			rs = stmt.executeQuery();
			while(rs.next()){
				Administor admin = new Administor();
				admin.setUsername(rs.getString("adname"));
				admin.setPassword(rs.getString("adpassword"));
				request.getSession().setAttribute("admin", admin);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
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



	public static void doUnLogin(HttpServletRequest request) {
		request.getSession().setAttribute("admin", null);
		
	}

}
