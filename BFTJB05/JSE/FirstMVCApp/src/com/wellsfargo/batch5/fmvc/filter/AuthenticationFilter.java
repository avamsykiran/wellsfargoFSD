package com.wellsfargo.batch5.fmvc.filter;

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

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {

			HttpServletRequest httpReq = (HttpServletRequest) request;
			HttpServletResponse httpResp = (HttpServletResponse) response;

			boolean isAllowed = true;

			if (!httpReq.getServletPath().equals("/login") &&
					!httpReq.getServletPath().equals("/login_page.jsp")) {
				if (httpReq.getSession().getAttribute("userName") == null) {
					isAllowed = false;
					httpResp.sendRedirect("login_page.jsp");
				}
			}

			if (isAllowed) {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
