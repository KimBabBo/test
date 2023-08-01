package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		DBConnection dbc = new DBConnection();
		try {
			dbc.insertMember(id, pw, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
