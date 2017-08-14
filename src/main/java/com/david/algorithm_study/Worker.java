package com.david.algorithm_study;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;

public class Worker implements Runnable {
	private int workId;
	private CountDownLatch latch;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Worker(int workId, CountDownLatch latch) {
		super();
		this.workId = workId;
		this.latch = latch;
	}

	public void doWork() throws InterruptedException {
		String workerName = "worker_" + workId;
		System.out.println(workerName + " work at =" + sdf.format(new Date()));
		TimeUnit.SECONDS.sleep(RandomUtils.nextInt(1, 3));
		latch.countDown();
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
