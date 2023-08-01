package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class EndAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Scheduler sched = null;
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			sched = sf.getScheduler();
			sched.shutdown();
			System.out.println("<<< 포인트 스케줄러의 실행이 종료되었습니다. >>>");
			response.sendRedirect("AdminPage.jsp");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
