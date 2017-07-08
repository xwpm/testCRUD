package com.test.contorller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Users;
import com.test.service.UserService;

@WebServlet(name = "UpdateUser", urlPatterns = "/updateUser")
public class UpdateUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService service;

	@Override
	public void init() throws ServletException {
		service = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if (op == null || op.equals("")) {
			transmit(req, resp);
		} else {
			if (op.equals("updateUser")) {
				updateUser(req, resp);
			}
		}

	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("u_id");
		String uname = req.getParameter("u_name");
		String upassword = req.getParameter("u_password");
		Users user = new Users(Integer.parseInt(uid), uname, upassword);
		int a = service.updateUser(user);
		if (a > 0) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}

	}

	private void transmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("u_id");
		Users user = new Users();
		user = service.queryUserById(uid);
		req.setAttribute("user", user);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}

}
