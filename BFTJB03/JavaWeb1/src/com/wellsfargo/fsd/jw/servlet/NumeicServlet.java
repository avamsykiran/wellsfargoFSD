package com.wellsfargo.fsd.jw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arth")
public class NumeicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int n1=0,n2=0;
		
		if(req.getParameter("n1")!=null) {
			n1 = Integer.parseInt(req.getParameter("n1"));
		}
		
		if(req.getParameter("n2")!=null) {
			n2 = Integer.parseInt(req.getParameter("n2"));
		}
		
		String operation = req.getParameter("operation");
		
		String result ="";
		
		switch(operation) {
		case "add": result = "Sum is " +(n1+n2); break;
		case "sub": result = "Difference is " +(n1-n2); break;
		case "mul": result = "Product is " +(n1*n2); break;
		case "divQ": result = "Quitiont is " +(n1/n2); break;
		case "divR": result = "Reminder is " +(n1%n2); break;		
		}
		
				
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("<p>"+result+"</p>");
		out.println("</body></html>");
	}

	
}
