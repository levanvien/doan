package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NguoiDungDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaEE_Example";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ket noi loi");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ket noi loi");

		}
	}

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		/*
		 * connect(); String sql= String.
		 * format("SELECT TenDangNhap FROM NguoiDung WHERE TenDangNhap = '%s' AND MatKhau = '%s'"
		 * , tenDangNhap, matKhau); ResultSet rs = null; try { Statement stmt =
		 * connection.createStatement(); rs = stmt.executeQuery(sql); } catch
		 * (SQLException e) { e.printStackTrace(); } try { if(rs.next()){ return
		 * true; } } catch (SQLException e) { e.printStackTrace(); } return
		 * false; }
		 */
		connect();
		String sql = String.format("SELECT TenDangNhap FROM NguoiDung WHERE TenDangNhap='%s' AND MatKhau='%s'",
				tenDangNhap, matKhau);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();

		}
		try {
			if (rs.next()) {
				return true;
			}
			// TODO: handle exception
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;

	}
}
