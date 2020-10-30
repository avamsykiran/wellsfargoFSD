package com.wellsfargo.batch5.fmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("unm");
		String password = request.getParameter("pwd");
		
		String view = "";
		
		if("admin".equals(userName)&&"admin".equals(password)) {
			session.setAttribute("userName", userName);
			view="index.jsp";
		}else {
			request.setAttribute("err","Invalid Credits");
			view="login_page.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

}
