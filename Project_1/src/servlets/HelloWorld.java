package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorld extends HttpServlet{
		
	
	
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		     
		PrintWriter out = response.getWriter();
		out.print("test pour le get ");
		out.flush();

	}
	
	
	
	
	
	
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		     
		PrintWriter out = response.getWriter();
		  
		out.print("test pour le post");
		out.flush();

	}
	
	protected void doDelete(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		String val = request.getParameter("id");
		
		response.setContentType("text/html");
		     
		PrintWriter out = response.getWriter();
		  
		out.print("test pour le delete " + val);
		out.flush();
	}
}