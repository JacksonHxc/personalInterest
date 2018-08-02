package org.hxc.multithreading.volatileExample;

import java.util.concurrent.atomic.AtomicInteger;

public class InvalidVolatile {

	//public static volatile int race = 0;
	public static AtomicInteger race = new AtomicInteger(0);
	private static final int THREADS_COUNT = 20;
	
	public static void increase() {
		//race ++; //read race and copy it from main memory to work memory
				 //after increment, writeback to main memory
				 //volatile can keep it changing, but race maybe out dated
		
		race.incrementAndGet();
	}
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		
		for(int i = 0; i < THREADS_COUNT; i++ ) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 10000; j++)
						increase();
				}
			});
			threads[i].start();
		}
		
		while(Thread.activeCount() > 1)
			Thread.yield();
		
		System.out.println(race);
	}
}
