package com.wellsfargo.batch7.fma.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/friends")
public class FriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		
		List<String> friends = (List<String>) context.getAttribute("friends");
		
		if (friends == null) {
			friends = new ArrayList<>();
		}

		String friendName = request.getParameter("fnm");

		if (friendName != null) {
			friends.add(friendName);
		}

		context.setAttribute("friends", friends);
		request.getRequestDispatcher("friends_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
