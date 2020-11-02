package com.wellsfargo.batch7.ab.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.Contact;
import com.wellsfargo.batch7.ab.service.ContactServiceImpl;
import com.wellsfargo.batch7.ab.service.IContactService;

@WebServlet({ "/listContacts", "/newContact", "/addContact", "/editContact", "/saveContact", "/deleteContact" })
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IContactService contactService;

	@Override
	public void init() throws ServletException {
		contactService = new ContactServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String incomingReqPath = request.getServletPath();
		String view = "";
		try {
			switch (incomingReqPath) {
			case "/listContacts":
				view = listContacts(request, response);
				break;
			case "/newContact":
				view = newContact(request, response);
				break;
			case "/addContact":
				view = addContact(request, response);
				break;
			case "/editContact":
				view = editContact(request, response);
				break;
			case "/saveContact":
				view = saveContact(request, response);
				break;
			case "/deleteContact":
				view = deleteContact(request, response);
				break;
			}
		} catch (AddressBookException exp) {
			request.setAttribute("errMsg", exp.getMessage());
			view = "error_page.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	private String deleteContact(HttpServletRequest request, HttpServletResponse response) throws AddressBookException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		contactService.delete(cid);
		request.setAttribute("msg", "Contact deleted sucessfully!");
		return "index.jsp";
	}

	private String saveContact(HttpServletRequest request, HttpServletResponse response) throws AddressBookException {
		Contact contact = new Contact();

		contact.setContactId(Integer.parseInt(request.getParameter("contactId")));
		contact.setName(request.getParameter("name"));
		contact.setGroup(request.getParameter("group"));
		contact.setMobile(request.getParameter("mobile"));
		contact.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));

		contactService.save(contact);

		request.setAttribute("msg", "Contact saved sucessfully!");
		return "index.jsp";
	}

	private String editContact(HttpServletRequest request, HttpServletResponse response) throws AddressBookException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Contact contact = contactService.getById(cid);

		request.setAttribute("isNew", false);
		request.setAttribute("contact", contact);
		return "contact_form_page.jsp";
	}

	private String addContact(HttpServletRequest request, HttpServletResponse response) throws AddressBookException {
		Contact contact = new Contact();

		contact.setContactId(Integer.parseInt(request.getParameter("contactId")));
		contact.setName(request.getParameter("name"));
		contact.setGroup(request.getParameter("group"));
		contact.setMobile(request.getParameter("mobile"));
		contact.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));

		contactService.add(contact);

		request.setAttribute("msg", "Contact added sucessfully!");
		return "index.jsp";
	}

	private String newContact(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("isNew", true);
		return "contact_form_page.jsp";
	}

	private String listContacts(HttpServletRequest request, HttpServletResponse response) throws AddressBookException {
		request.setAttribute("contacts", contactService.getAll());
		return "contacts_list_page.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
