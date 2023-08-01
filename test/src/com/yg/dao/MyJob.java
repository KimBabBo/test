package com.yg.dao;
import java.time.LocalDateTime;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		DBConnection dbc = new DBConnection();
		try {
			int cnt = dbc.UpPointSch();
			LocalDateTime current = LocalDateTime.now();
			System.out.println("Job이 실행됨 : "+current + " / "+cnt+"명에게 포인트 부여 1점");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





