package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.service.UserService;


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String page = request.getParameter("page");// /home /login /sign-up /contact /
		session =request.getSession();
		if(page == null) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			doPost(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		session =request.getSession();
		if (page.equalsIgnoreCase("home")) {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		else
		if (page.equalsIgnoreCase("login")) {
			request.setAttribute("error_msg", "");
			request.setAttribute("username", "");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else
		if (page.equalsIgnoreCase("sign-up")) {
			request.getRequestDispatcher("sign-up.jsp").forward(request,response);
		}
		else
		if (page.equalsIgnoreCase("contact")) {
			request.getRequestDispatcher("contact.jsp").forward(request,response);
		}
		else {}
		
		if(page.equalsIgnoreCase("loginForm")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//System.out.println(username +" " + password);
			UserService userService = new UserService();
			boolean isPresent = userService.validateCredentials(username,password);
			if(isPresent) {
				//Starting Session
				session.setAttribute("username", username); // <key:username, value:harry>
				request.getRequestDispatcher("productHome.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error_msg", "Invalid Credentials");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else
		if (page.equalsIgnoreCase("logout")) {
			session.invalidate();
			request.setAttribute("error_msg", "Logout Success!!!");
			request.setAttribute("username", "");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {}
		
	}
}
