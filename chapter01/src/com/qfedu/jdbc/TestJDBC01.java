package com.qfedu.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestJDBC01 {
	public static void main(String[] args) throws Exception {
		//加载并注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver"); 
		String url ="jdbc:mysql://localhost:3306/chapter01";
		String username="root";
		String password ="root";
		//获取数据库连接
	 	Connection conn =DriverManager.getConnection(url,username,password);
	 	Statement statement = conn.createStatement();
		//获取执行者对象
	    String sql = "select * from student where sname ='zhangsan' ";
	    //执行SQL语句
		ResultSet resultSet = statement.executeQuery(sql);
	    System.out.println("sid|sname|age|course");
	    //处理结果集
	    while (resultSet.next()) {
			int sid = resultSet.getInt("sid");
	    	String sname = resultSet.getString("sname");
	    	String age = resultSet.getString("age");
	    	String course = resultSet.getString("course");
	    	System.out.println(sid+"|"+sname+"|"+age+"|"+course);
		}
	  	//关闭资源
	    resultSet.close();
	    statement.close();
		conn.close();
	}
}
