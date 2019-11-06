package day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Exam_01 {

	public static void main(String[] args) throws Exception{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.建立连接
		String url="jdbc:mysql://localhost:3306/t_umsl?"
				+ "useUnicode=true&characterEncoding=utf8";
		//jdbc:mysql://主机地址：端口号/表名+设置识别中文
		String user="root";
		String password="";
		Connection conn = DriverManager.getConnection(url,user,password);
		//打桩：判断上述操作是否正确
		System.out.println(conn);
		
		
		//写sql语句
		String sql="select * from emp";
		//创建PreparedStatement对象，来执行sql语句
		java.sql.PreparedStatement ps=conn.prepareStatement(sql);
		//创建ResultSet对象并返回结果集
		ResultSet rs=ps.executeQuery();
		//遍历结果集
		while(rs.next()){
			int id=rs.getInt("id");
			String username=rs.getString("password");
			String pwd=rs.getString("password");
			String email=rs.getString("email");
			System.out.println(id+" "+username+" "+pwd+" "+email);
		}
	}

}
