package com.qfedu.jdbc.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Exercise_01 {
	public static void main(String[] args) throws  Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chapter01", "root", "root");
		PreparedStatement pstat = conn.prepareStatement("select * from student where sname like ?");
		pstat.setString(1, "%zhangsan%");
		ResultSet resultSet = pstat.executeQuery();
		System.out.println("sid|sname|age|course");
		while (resultSet.next()) {
			int sid = resultSet.getInt("sid");
	    	String sname = resultSet.getString("sname");
	    	String age = resultSet.getString("age");
	    	String course = resultSet.getString("course");
	    	System.out.println(sid+"|"+sname+"|"+age+"|"+course);
		} 
	} 
}
