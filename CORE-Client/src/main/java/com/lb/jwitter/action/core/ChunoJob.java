package com.lb.jwitter.action.core;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ChunoJob  implements Job{

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		 
				System.out.println("Hello Quartz!-start");	
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hello Quartz!-end");	
	}

}
