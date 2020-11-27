package com.qfedu.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class TestJDBC02 {
	public static void main(String[] args) throws Exception {
		//加载并注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver"); 
		String url ="jdbc:mysql://localhost:3306/chapter01";
		String username="root";
		String password ="root";
		//获取数据库连接
	 	Connection conn =DriverManager.getConnection(url,username,password);
	 	//书写SQL语句
	 	String sql = "select * from student where sname = ?";
	 	//获取执行者对象
	 	PreparedStatement pstat  = conn.prepareStatement(sql);
		//设置参数
	 	pstat.setString(1, "zhangsan");
	    //执行SQL语句
	    ResultSet resultSet = pstat.executeQuery();
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
		pstat.close();
		conn.close();
	}
}
