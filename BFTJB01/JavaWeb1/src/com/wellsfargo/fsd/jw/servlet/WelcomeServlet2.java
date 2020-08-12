package com.wellsfargo.fsd.jw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ws2")
public class WelcomeServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("unm");

		if (userName == null) {
			userName = "SomeBody";
		}

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<h2> Hello! <strong>"+userName+"</strong></h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
