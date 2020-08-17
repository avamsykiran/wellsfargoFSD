package com.wellsfargo.fsd.jw2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletB
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m1 = request.getParameter("m1");
		String m2 = (String)request.getAttribute("m2");
		String m3 = "A message form servlet B";
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h3>M1 (from client): "+m1+"</h3>");
		out.println("<h3>M2 (from servlet A): "+m2+"</h3>");
		out.println("<h3>M3 (from servlet B): "+m3+"</h3>");
		out.println("<hr /><a href='index.jsp'>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
