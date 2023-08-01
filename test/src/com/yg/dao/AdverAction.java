package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdverAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int random = (int)(Math.random()*1000)+1;
		String name = request.getParameter("name");
		DBConnection dbc = new DBConnection();
		try {
			int returnPoint = dbc.advPoint(random, name);
			request.setAttribute("returnPoint",returnPoint); 
			request.setAttribute("name",name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("Main.jsp?random="+random).forward(request, response);
		
	}

}
