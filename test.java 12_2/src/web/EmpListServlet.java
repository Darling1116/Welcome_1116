package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class EmpListServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		//ArrayList<Emp> list = dao.selectAll();
		
		
		String tmp = request.getParameter("current");
		int current;
		if(tmp==null){
			current = 1;
		}
		else{
			current = Integer.parseInt(tmp);
		}
		ArrayList<Emp> list = dao.selectAll(current,5);
	
		
		
		
		//Я������key----value
		request.setAttribute("emps", list);
		request.getRequestDispatcher("listEmp.jsp").forward(request, response);
		//ת��listEmp.jsp�ļ�
		
		
		
	/*	
		response.setContentType("text/html;charset=utf-8");
		//�޸��ַ���
		
		PrintWriter pw = response.getWriter();
		for(Emp e:list){
			pw.print("Ա��id "+e.getId()+" ");
			pw.print("����name "+e.getName()+" ");
			pw.print("gender "+e.getGender()+" ");
			pw.print("�绰phone "+e.getPhone()+" ");
			pw.print("����empno "+e.getEmpNo()+" ");
			pw.print("����dpetno "+e.getDeptNo()+" ");
			pw.print("����age "+e.getAge());
			
			pw.println("<br>");
		}
	}
	
	*/
	}	
}
