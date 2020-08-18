package com.wellsfargo.fsd.ims.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.ims.entity.Item;
import com.wellsfargo.fsd.ims.exception.ImsException;
import com.wellsfargo.fsd.ims.service.ItemService;
import com.wellsfargo.fsd.ims.service.ItemServiceImpl;

/**
 * Servlet implementation class ImsFrontController
 */
@WebServlet({ "/list", "/newItem", "/addItem", "/deleteItem", "/editItem", "/saveItem" })
public class ImsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemService itemService;

	@Override
	public void init() throws ServletException {
		itemService = new ItemServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();
		String viewName="";
		
		switch(url) {
		case "/list":viewName = doList(request, response);break;
		case "/newItem":viewName=doNewITem(request, response);break;
		case "/addItem":viewName=doAddItem(request, response); break;
		case "/deleteItem":viewName=doDeleteItem(request, response);break;
		case "/editItem":viewName=doEditItem(request, response);break;
		case "/saveItem":viewName=doSaveItem(request, response);break;
		}
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String doList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String view="";
		
		try {
			List<Item> items = itemService.getAllItems();
			request.setAttribute("items", items);
			view="itemsListPage.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		
		return view;
	}

	private String doNewITem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Item item = new Item();
		request.setAttribute("item", item);
		
		return "itemFormPage.jsp";
	}

	private String doAddItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		Item item = new Item();
		
		item.setIcode(Integer.parseInt(request.getParameter("icode")));
		item.setTitle(request.getParameter("title"));
		item.setFragile(Boolean.parseBoolean(request.getParameter("fragile")));
		item.setUnit(request.getParameter("unit"));
		item.setPackageDate(LocalDate.parse(request.getParameter("packageDate")));
		item.setCostPrice(Double.parseDouble(request.getParameter("costPrice")));
		item.setSellingPrice(Double.parseDouble(request.getParameter("sellingPrice")));
		
		String view="";
		
		try {
			itemService.validateAndAdd(item);
			request.setAttribute("msg", "Item Got Added!");
			view="index.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}

	private String doDeleteItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int icode = Integer.parseInt(request.getParameter("icode"));
		String view="";
		
		try {
			itemService.deleteItem(icode);
			request.setAttribute("msg", "Item Got Deleted!");
			view="index.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}

	private String doEditItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int icode = Integer.parseInt(request.getParameter("icode"));
		String view="";
						
		try {
			Item item = itemService.getItemById(icode);
			request.setAttribute("item", item);
			view="itemFormPage.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}

	private String doSaveItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	Item item = new Item();
		
		item.setIcode(Integer.parseInt(request.getParameter("icode")));
		item.setTitle(request.getParameter("title"));
		item.setFragile(Boolean.parseBoolean(request.getParameter("fragile")));
		item.setUnit(request.getParameter("unit"));
		item.setPackageDate(LocalDate.parse(request.getParameter("packageDate")));
		item.setCostPrice(Double.parseDouble(request.getParameter("costPrice")));
		item.setSellingPrice(Double.parseDouble(request.getParameter("sellingPrice")));
		
		String view="";
		
		try {
			itemService.validateAndSave(item);
			request.setAttribute("msg", "Item Got Saved!");
			view="index.jsp";
		} catch (ImsException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		return view;
	}
}
