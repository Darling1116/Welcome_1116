package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;

public class EmpDeleteServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	int  eId = Integer.parseInt(id);
	EmpDao dao=new EmpDao();
	int result=dao.deleteById(eId);
	//无论删除成功还是失败，servlet重定向到列表请求
	response.sendRedirect("emplist.html");
}
}
