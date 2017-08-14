package com.david.algorithm_study;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CooperativeWork {
	
	private static final CountDownLatch latch = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(3);
		Boss boss = new Boss(latch);
		Worker worker1 = new Worker(1, latch);
		Worker worker2 = new Worker(2, latch);
		
		List<Runnable> list = new ArrayList<>(Arrays.asList(new Runnable[] { boss, worker1, worker2 }));
		for (Runnable item : list) {
			System.out.println(item);
			TimeUnit.SECONDS.sleep(1);
			service.execute(item);
		}
		
		ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
		
	}
}
