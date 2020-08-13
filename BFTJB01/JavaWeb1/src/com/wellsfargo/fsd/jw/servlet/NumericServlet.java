package com.wellsfargo.fsd.jw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arth")
public class NumericServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		
		String opt = req.getParameter("operation");
		
		String result = "";
		
		switch(opt) {
		case "sum": result = "Sum is " + (n1+n2); break;
		case "dif":result = "Difference is " + (n1-n2); break;
		case "prd":result = "Product is " + (n1*n2); break;
		case "qut":result = "Quitiont is " + (n1/n2); break;
		case "rem":result = "Reminder is " + (n1%n2); break;
		}
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>"+result+"</h1>");
		out.println("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
		
}
