package com.wellsfargo.fsd.jw2.filter;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ExecTimeFilter
 */
@WebFilter("/*")
public class ExecTimeFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		LocalDateTime startTime = LocalDateTime.now();
		chain.doFilter(request, response);
		LocalDateTime endTime = LocalDateTime.now();
		
		Duration dur = Duration.between(startTime, endTime);
		System.out.println("It took "+dur.toMillis() +"ms to respond");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
