package com.wellsfargo.fsd.lms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;
import com.wellsfargo.fsd.lms.service.LoanServiceImpl;

/**
 * Servlet implementation class LmsFrontController
 */
@WebServlet({ "/list", "/deleteLoan", "/newLoan", "/addLoan", "/editLoan", "/saveLoan" })
public class LmsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoanService loanService;

	@Override
	public void init() throws ServletException {
		loanService = new LoanServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();

		String view = "";

		switch (url) {
		case "/list":
			view = doListLoans(request, response);
			break;
		case "/deleteLoan":
			view = doDeleteLoan(request, response);
			break;
		case "/newLoan":
			view = doAddLoan(request, response);
			break;
		case "/addLoan":
			view = doCreateorSaveLoan(request, response);
			break;
		case "/editLoan":
			view = doEditLoan(request, response);
			break;
		case "/saveLoan":
			view = doCreateorSaveLoan(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String doListLoans(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		try {
			List<Loan> loans = loanService.getAllLoans();
			request.setAttribute("loans", loans);
			view = "loanListPage.jsp";
		} catch (LoanException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String doAddLoan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		Loan loan = new Loan();
		request.setAttribute("loan", loan);
		request.setAttribute("isNew", true);
		view = "loanFormPage.jsp";

		return view;
	}

	private String doEditLoan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		int loanId = Integer.parseInt(request.getParameter("id"));
		try {
			Loan loan = loanService.getLoan(loanId);
			request.setAttribute("loan", loan);
			request.setAttribute("isNew", false);
			view = "loanFormPage.jsp";
		} catch (LoanException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String doCreateorSaveLoan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Loan loan = new Loan();
		
		loan.setLoanId(Integer.parseInt(request.getParameter("loanId")));
		loan.setPrincipal(Double.parseDouble(request.getParameter("principal")));
		loan.setRateOfInterest(Double.parseDouble(request.getParameter("rateOfInterest")));
		loan.setEmiCount(Integer.parseInt(request.getParameter("emiCount")));
		loan.setStatus(request.getParameter("status"));
		loan.setDateOfDisbursment(LocalDate.parse(request.getParameter("dateOfDisbursment")));
		
		String view = "";
		
		try {
			
			if(request.getServletPath().equals("/addLoan")) {
				loanService.validateAndAdd(loan);
			}else {
				loanService.validateAndSave(loan);
			}
			
			request.setAttribute("msg", "Loan is saved");
			view="index.jsp";
		} catch (LoanException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String doDeleteLoan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		int loanId = Integer.parseInt(request.getParameter("id"));
		try {
			loanService.deleteLoan(loanId);
			request.setAttribute("msg", "Loan Record Deleted!");
			view = "index.jsp";
		} catch (LoanException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}
}
