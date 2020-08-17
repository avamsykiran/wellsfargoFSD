package com.wellsfargo.fsd.jw2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/todos")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HttpSession session = request.getSession();				
		
		//List<String> taskList = (List<String>)session.getAttribute("tasks");
		
		ServletContext context = getServletContext();
		
		List<String> taskList = (List<String>)context.getAttribute("tasks");
		
		if(taskList==null) {
			taskList = new ArrayList<>();
		}
		
		String task = request.getParameter("task");
		
		if(task!=null) {
			taskList.add(task);
		}
		
		//session.setAttribute("tasks", taskList);
		
		context.setAttribute("tasks", taskList);
		request.getRequestDispatcher("todoPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
