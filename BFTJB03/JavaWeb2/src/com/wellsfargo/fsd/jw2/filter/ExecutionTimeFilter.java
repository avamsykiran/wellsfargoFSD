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
 * Servlet Filter implementation class ExecutionTimeFilter
 */
@WebFilter("/*")
public class ExecutionTimeFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		LocalDateTime startTime = LocalDateTime.now();

		chain.doFilter(request, response);
		
		LocalDateTime endTime = LocalDateTime.now();
		
		System.out.println("It toook " + Duration.between(startTime, endTime).toNanos() + "ns time to respond");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
