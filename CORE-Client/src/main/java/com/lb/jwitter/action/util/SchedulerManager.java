//package com.lb.jwitter.action.util;
//
//import org.quartz.*;
//import org.quartz.impl.StdScheduler;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//
//public class SchedulerManager {
//
//	private Scheduler scheduler;
//
//	
//
//	public Scheduler getScheduler() {
//		return scheduler;
//	}
//
//	public void setScheduler(Scheduler scheduler) {
//		this.scheduler = scheduler;
//	}
//
//	public void startScheduler() throws SchedulerException{
//		
//		
//		 scheduler.start();
//	}
//	
//	public void stopScheduler() throws SchedulerException{
//		if(scheduler.isStarted()){
//			scheduler.standby();
//		}
//	}
//	
//	public Boolean isRunning() throws SchedulerException{
//		return scheduler.isStarted() && !scheduler.isInStandbyMode();
//	}
//}
//
