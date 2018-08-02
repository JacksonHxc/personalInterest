package org.hxc.multithreading.volatileExample;

//为什么一直busy无法跳出线程？
//background进程中并无与主线程同步的机制
//线程内存与主线程无内存同步
//因此引入volatile来同步变量

import java.util.concurrent.TimeUnit;

public class StopThread {
	
	private static boolean stopRequested;
	private static volatile boolean stopRequested1;
	
	public static void main(String[] args) throws InterruptedException {
		
		//主线程生成的一个子线程
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while(!stopRequested1) {
				//while(!stopRequested) {
					//println是IO操作，会释放cpu, 再次执行会刷新内存，得到新的stopRequested的值
					//System.out.println(i);
					i ++;
				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		//stopRequested = true;
		stopRequested1 = true;
		System.out.println("Thread stopped!");
	}
}
