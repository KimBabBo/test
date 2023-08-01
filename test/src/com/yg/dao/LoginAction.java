package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		DBConnection dbc = new DBConnection();
		String name="";
		int point=0;
		try {
			name = dbc.checkLogin(id, pw);
			point = dbc.checkPoint(id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!(id.equals("admin"))) {
			if(name!="") {
				request.setAttribute("name",name);
				request.setAttribute("point",point);
				request.getRequestDispatcher("Main.jsp").forward(request, response);
			} else {
			    response.sendRedirect("Login.jsp?denied=x");
			}
		} else if(id.equals("admin")){
			response.sendRedirect("AdminPage.jsp");
		}

	}

}
