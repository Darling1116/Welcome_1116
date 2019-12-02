package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import entity.Emp;

public class EmpDao {
	public ArrayList<Emp> selectAll(int current,int size){
		ArrayList<Emp> list = new ArrayList<Emp>();
	try{	
		new Driver();
		
		String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="";
		Connection con = (Connection) DriverManager.getConnection(url, user, password);
		
		//String sql = "select * from t_emp";
		String sql = "select * from t_emp limit ?,?";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.setInt(1, (current-1)*size);
		ps.setInt(2, size);
		
		
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			int eId=rs.getInt("id");
			String eName = rs.getString("name");
			String eGender = rs.getString("gender");
			String ePhone = rs.getString("phone");
			String eEmpno = rs.getString("empno");
			int eDeptno = rs.getInt("deptno");
			int eAge = rs.getInt("age");
			Emp e = new Emp(eId,eName,eGender,ePhone,eEmpno,eDeptno,eAge);
			list.add(e);
			
		}	
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return list;
	
	
	}
	
	
public Emp selectOne(String name ,String empno){
		
		try {
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
			String user="root";
			String password="";
			Connection conn=(Connection) DriverManager.getConnection(url, user, password);
			// 把sql语句添加limit 其中两个参数用问号占位符定义
			String sql="select * from t_emp where name=? and empno=?";
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			//把问号占位符用变量来表示，其中问号的位置从1开始，
			ps.setString(1, name);
			ps.setString(2, empno);
			ResultSet rs=ps.executeQuery();// DQL必须用jdbc的executeQuery
			if(rs.next()){
				int eId=rs.getInt("id");
				String eName = rs.getString("name");
				String eGender = rs.getString("gender");
				String ePhone = rs.getString("phone");
				String eEmpno = rs.getString("empno");
				int eDeptno = rs.getInt("deptno");
				int eAge = rs.getInt("age");
				Emp e = new Emp(eId,eName,eGender,ePhone,eEmpno,eDeptno,eAge);
				return e;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


public int deleteById(int eId){
	try{
		
		new Driver();
		String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="";
		Connection conn=(Connection) DriverManager.getConnection(url, user, password);
		String sql="delete from t_emp where id=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1,eId);
		int result=ps.executeUpdate();// jdbc中规定DML语句全用executeUpdate方法进行提交到数据库  Insert  update  delete  
		return result;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}
}
}
