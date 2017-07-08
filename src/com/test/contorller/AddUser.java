package com.test.contorller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Users;
import com.test.service.UserService;

@WebServlet(name = "AddUser", urlPatterns = "/addUser")
public class AddUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("u_name");
		String pwd = req.getParameter("u_password");
		Users user = new Users();
		user.setU_name(name);
		user.setU_password(pwd);
		int a = service.addUser(user);
		if (a > 0) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
