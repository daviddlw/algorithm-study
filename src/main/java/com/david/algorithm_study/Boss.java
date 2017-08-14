package com.david.algorithm_study;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable {

	private CountDownLatch latch;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Boss(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	public void doWork() throws InterruptedException {
		latch.await();
		System.out.println("I will check the job");
		System.out.println("boss finish work at=" + sdf.format(new Date()));
	}

	@Override
	public void run() {
		try {
			doWork();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
