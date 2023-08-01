package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMember implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DBConnection dbc = new DBConnection();
		try {
			dbc.deleteMember(id);
			response.sendRedirect("AdminPage.jsp?delete=ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
