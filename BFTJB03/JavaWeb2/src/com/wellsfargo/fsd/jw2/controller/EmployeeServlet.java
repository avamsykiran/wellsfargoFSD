package com.wellsfargo.fsd.jw2.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.jw2.model.EmployeeModel;
import com.wellsfargo.fsd.jw2.service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/es")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeModel emp = new EmployeeModel();
		emp.setFullName(request.getParameter("fullName"));
		emp.setBasic(Double.parseDouble(request.getParameter("basic")));
		emp.setHiredate(LocalDate.parse(request.getParameter("hiredate")));
		
		EmployeeService empService = new EmployeeService();
		empService.computeAll(emp);
		
		request.setAttribute("model", emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("empPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
