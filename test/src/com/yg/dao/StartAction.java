package com.yg.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class StartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = null;
		try {
			sched = sf.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		JobDetail job = JobBuilder.newJob(MyJob.class)
									.withIdentity("myjob", "group1")
									.build();
		Trigger trigger = TriggerBuilder.newTrigger()
									.withIdentity("myTrigger", "group1")
									.startNow()
									.withSchedule(SimpleScheduleBuilder.simpleSchedule()
												.withIntervalInSeconds(20)
												.repeatForever())
									.build();
		try {
			sched.scheduleJob(job, trigger);
			System.out.println("<<< 포인트 스케줄러가 시작되었습니다. >>>");
			sched.start();
			response.sendRedirect("AdminPage.jsp");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
