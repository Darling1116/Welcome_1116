package web1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

public class HHServlet extends HttpServlet {

protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
	PrintWriter pw = response.getWriter();
	pw.print("hello this is my first dynamic web page");
	
}

}
