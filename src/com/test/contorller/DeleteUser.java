package com.test.contorller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.UserService;

@WebServlet(name = "DeleteUser", urlPatterns = "/deleteUser")
public class DeleteUser extends HttpServlet {

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
		String uid = req.getParameter("u_id");
		int a = service.deleteUserById(uid);
		if (a > 0) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
