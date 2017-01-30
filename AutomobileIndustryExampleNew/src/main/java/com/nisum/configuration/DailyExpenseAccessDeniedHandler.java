package com.nisum.configuration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class DailyExpenseAccessDeniedHandler implements AccessDeniedHandler  {
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException arg2)
			throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/accessdenied");
		dispatcher.forward(request, response);
	}
}
