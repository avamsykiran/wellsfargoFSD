package com.wellsfargo.batch7.ab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.AdbUser;
import com.wellsfargo.batch7.ab.service.AdbUserServiceImpl;
import com.wellsfargo.batch7.ab.service.IAdbUserService;

@WebServlet({ "/login", "/logout", "/register" })
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IAdbUserService userService;

	@Override
	public void init() throws ServletException {
		this.userService = new AdbUserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String incomingReqPath = request.getServletPath();
		String view = "";

		switch (incomingReqPath) {
		case "/register":
			String userName = request.getParameter("unm");
			String password = request.getParameter("pwd");

			if (userName == null) {
				view = "register_page.jsp";
			} else {
				AdbUser newUser = new AdbUser(userName, password, "USER");
				try {
					userService.createUser(newUser);
					view = "index.jsp";
				} catch (AddressBookException e) {
					request.setAttribute("err", e.getMessage());
					view="error_page.jsp";
				}
			}
			break;
		case "/logout":
			session.removeAttribute("user");
			session.invalidate();
			view = "index.jsp";
			break;
		case "/login":
			String userName1 = request.getParameter("unm");
			String password1 = request.getParameter("pwd");

			if (userName1 == null) {
				view = "login_page.jsp";
			} else if (password1 == null) {
				request.setAttribute("err", "Password is not received!");
				view = "login_page.jsp";
			} else {
				try {
					AdbUser user = userService.authenticate(userName1, password1);
					session.setAttribute("user", user);
					view = "index.jsp";
				} catch (AddressBookException e) {
					request.setAttribute("err", e.getMessage());
					view = "login_page.jsp";
				}
			}
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
