package com.wellsfargo.batch5.fwa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		LocalDateTime now = LocalDateTime.now();
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.include(req, resp);	
		
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Content for servlet</title></head><body>");
		out.println("<h1>This is a content from servlet</h1>");
		out.println("<h1>"+now+"</h1>");
		out.println("</body></html>");
	}
	
}
