package com.wellsfargo.batch7.fma.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch7.fma.model.Loan;
import com.wellsfargo.batch7.fma.service.ILoanService;
import com.wellsfargo.batch7.fma.service.LoanServiceImpl;

@WebServlet("/si")
public class SimpleInterestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ILoanService loanService;
	
	public void init(ServletConfig config) throws ServletException {
		loanService = new LoanServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Loan loan = new Loan();
		
		loan.setLoanAmount(Double.parseDouble(request.getParameter("loanAmount")));
		loan.setRate(Double.parseDouble(request.getParameter("rate")));
		loan.setDisbursementDate(LocalDate.parse(request.getParameter("disbursementDate")));
		loan.setDueDate(LocalDate.parse(request.getParameter("dueDate")));
		
		loan = loanService.computeInterest(loan);
		
		request.setAttribute("loan", loan);
		
		String view = "simple_interest_display_page.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
