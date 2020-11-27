package com.qfedu.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class TestJDBC03 {
	public static void main(String[] args) throws Exception {
		//加载并注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver"); 
		String url ="jdbc:mysql://localhost:3306/chapter01";
		String username="root";
		String password ="root";
		//获取数据库连接
	 	Connection conn =DriverManager.getConnection(url,username,password);
	 	//书写SQL语句
	 	String sql = "insert into student (sname,age,course) values(?,?,?)";
	 	//获取执行者对象
	 	PreparedStatement  pstat =conn.prepareStatement(sql);
 	       for(int i=0;i<=2;i++){
 	           //为字段赋值
 	    	   pstat.setString(1, "name"+i);
 	    	   pstat.setString(2, "22");
 	    	   pstat.setString(3, "Java");
 	           //添加进批
 	    	   pstat.addBatch();
 	           //设置条件当i对10取余为0时，先执行一次批语句，然后将批清除
 	           if(i%10==0){
 	            	pstat.executeBatch();
 	            	pstat.clearBatch();
 	           }
 	       }
 	      //将批中剩余的语句执行完毕
 	      pstat.executeBatch();
	  	//关闭资源
		pstat.close();
		conn.close();
	}
}
