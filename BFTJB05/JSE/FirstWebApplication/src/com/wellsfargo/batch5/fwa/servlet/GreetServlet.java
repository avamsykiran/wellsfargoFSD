package com.wellsfargo.batch5.fwa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("unm");
		
		if(userName==null) {
			userName="Somebody";
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.include(request, response);	
			
		out.println("<html><head><title>Greet</title></head><body>");
		out.println("<h1> Hello! " + userName + "</h1></body></html>");
	}

}
