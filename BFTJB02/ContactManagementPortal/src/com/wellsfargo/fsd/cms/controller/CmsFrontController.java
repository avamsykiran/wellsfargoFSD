package com.wellsfargo.fsd.cms.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;
import com.wellsfargo.fsd.cms.service.ContactServiceImpl;

/**
 * Servlet implementation class CmsFrontController
 */
@WebServlet({ "/list", "/newContact", "/addContact", "/deleteContact", "/editContact", "/saveContact" })
public class CmsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContactService contactService;

	@Override
	public void init() throws ServletException {
		contactService = new ContactServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();
		String view = "";

		switch (url) {
		case "/list":
			view = doList(request, response);
			break;
		case "/newContact":
			view = doNewContact(request, response);
			break;
		case "/addContact":
			view = doAddorSaveContact(request, response);
			break;
		case "/deleteContact":
			view = doDeleteContact(request, response);
			break;
		case "/editContact":
			view = doEditContact(request, response);
			break;
		case "/saveContact":
			view = doAddorSaveContact(request, response);
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String doList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		try {
			List<Contact> contacts = contactService.getAllContacts();
			request.setAttribute("contacts", contacts);
			view = "contactsPage.jsp";
		} catch (ContactException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String doNewContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = new Contact();
		request.setAttribute("contact", contact);
		request.setAttribute("isNew", true);
		String view = "contactFormPage.jsp";
		return view;
	}

	private String doEditContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String view = "";

		try {
			Contact contact = contactService.getContact(cid);
			request.setAttribute("contact", contact);
			request.setAttribute("isNew", false);
			view = "contactFormPage.jsp";
		} catch (ContactException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String doAddorSaveContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contact = new Contact();

		contact.setContactId(Integer.parseInt(request.getParameter("contactId")));
		contact.setFullName(request.getParameter("fullName"));
		contact.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
		contact.setMobile(request.getParameter("mobile"));

		String view = "";

		try {
			if (request.getServletPath().equals("/addContact")) {
				contactService.validateAndAdd(contact);
			} else if (request.getServletPath().equals("/saveContact")) {
				contactService.validateAndSave(contact);
			}
			request.setAttribute("msg", "Contact Saved Successfully");
			view = "index.jsp";
		} catch (ContactException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		return view;
	}

	private String doDeleteContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String view = "";

		try {
			contactService.deleteContact(cid);			
			request.setAttribute("msg","Contact deleted");
			view = "index.jsp";
		} catch (ContactException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

}
