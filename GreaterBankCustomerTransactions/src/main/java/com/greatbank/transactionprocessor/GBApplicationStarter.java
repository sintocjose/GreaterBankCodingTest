package com.greatbank.transactionprocessor;


/**
 * @author Sinto
 *
 */
public class GBApplicationStarter {

	public static void main(String[] args) {
		TaskExecutor task = new TaskExecutorImpl();
		GBScheduler scheduler1 = new GBScheduler(task);
		scheduler1.startExecutionAt(6,0, 0);
		GBScheduler scheduler2 = new GBScheduler(task);
		scheduler2.startExecutionAt(21, 0, 0);
	}
	
}
