package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value = Integer.parseInt(request.getParameter("value"));
		String name = request.getParameter("name");
		DBConnection dbc = new DBConnection();
		int point=0;
		String content = "";
		if(value==100000) {
			content="intro";
		} else if(value==300000) {
			content="C++";
		} else {
			content = "java";
		}
		try {
			point = dbc.returnPoint(name);
			if(value>point) {
				request.setAttribute("name", name);
				request.setAttribute("point", point);
				request.getRequestDispatcher("Main.jsp?result=payDown").forward(request, response);
			} else {
				dbc.buyContents(name,value);
				request.setAttribute("name", name);
				request.setAttribute("point", point);
				request.getRequestDispatcher("Main.jsp?result=payUP&content="+content).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
