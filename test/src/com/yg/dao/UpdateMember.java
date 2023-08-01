package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMember implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		DBConnection dbc = new DBConnection();
		try {
			dbc.updateMember(id, pw, name, point);
			response.sendRedirect("AdminPage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
