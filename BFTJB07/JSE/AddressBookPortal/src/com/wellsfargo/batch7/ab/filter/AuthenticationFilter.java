package com.wellsfargo.batch7.ab.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch7.ab.model.AdbUser;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {

			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;

			AdbUser user = (AdbUser) httpRequest.getSession().getAttribute("user");

			String incomingUrl = httpRequest.getServletPath();

			Status status = null;

			String[] allowedUrls = null;

			if (user == null) {
				allowedUrls = new String[] { 
						"/index.jsp", "/login", 
						"/register", "/login_page.jsp",
						"/register_page.jsp",
						"/error_page.jsp","/access_denied_page.jsp" };
				for (String au : allowedUrls) {
					if (au.equals(incomingUrl)) {
						status = Status.AUTHORIZED;
						break;
					}
				}
				if (status == null) {
					status = Status.UN_AUTHENTICATED;
				}
			} else if (user.getRole().equals("USER")) {
				allowedUrls = new String[] { 
						"/index.jsp", "/logout", 
						"/listContacts","/contacts_list_page.jsp",
						"/error_page.jsp","/access_denied_page.jsp" };
				for (String au : allowedUrls) {
					if (au.equals(incomingUrl)) {
						status = Status.AUTHORIZED;
						break;
					}
				}
				if (status == null) {
					status = Status.UN_AUTHORIZED;
				}
			}else if (user.getRole().equals("ADMIN")) {
				status = Status.AUTHORIZED;				
			}

			if (status == Status.AUTHORIZED) {
				chain.doFilter(request, response);
			} else if (status == Status.UN_AUTHORIZED) {
				httpResponse.sendRedirect("access_denied_page.jsp");
			} else if (status == Status.UN_AUTHENTICATED) {
				httpResponse.sendRedirect("login_page.jsp");
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

	}

}

enum Status {
	UN_AUTHENTICATED, UN_AUTHORIZED, AUTHORIZED
}