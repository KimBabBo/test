package com.yg.dao;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String[] args) throws Exception {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		JobDetail job = JobBuilder.newJob(MyJob.class)
									.withIdentity("myjob", "group1")
									.build();
		Trigger trigger = TriggerBuilder.newTrigger()
									.withIdentity("myTrigger", "group1")
									.startNow()
									.withSchedule(SimpleScheduleBuilder.simpleSchedule()
												.withIntervalInSeconds(1)
												.repeatForever())
									.build();
		sched.scheduleJob(job, trigger);
		sched.start();
		sched.shutdown();
	}
}



