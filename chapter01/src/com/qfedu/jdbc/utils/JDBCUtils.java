package com.qfedu.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/chapter01";
	private static String user = "root";
	private static String pass = "root";
	private static Connection conn = null;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		}catch(Exception ex){
			ex.printStackTrace();
			//数据库连接失败,直接停止程序,抛出运行时期异常
			throw new RuntimeException("数据库连接失败");
		}
	}
	//获取链接
	public static Connection getConnecton(){
		return conn;
	}
	public static void release(Connection conn,PreparedStatement pstat,ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		
		release(conn,pstat);
	}
	public static void release(Connection conn,PreparedStatement pstat) {
		if (pstat!=null) {
			try {
				pstat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstat=null;
		}
		if (conn !=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
	}
}
