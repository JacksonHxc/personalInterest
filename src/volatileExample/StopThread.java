package org.hxc.multithreading.volatileExample;

//Ϊʲôһֱbusy�޷������̣߳�
//background�����в��������߳�ͬ���Ļ���
//�߳��ڴ������߳����ڴ�ͬ��
//�������volatile��ͬ������

import java.util.concurrent.TimeUnit;

public class StopThread {
	
	private static boolean stopRequested;
	private static volatile boolean stopRequested1;
	
	public static void main(String[] args) throws InterruptedException {
		
		//���߳����ɵ�һ�����߳�
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while(!stopRequested1) {
				//while(!stopRequested) {
					//println��IO���������ͷ�cpu, �ٴ�ִ�л�ˢ���ڴ棬�õ��µ�stopRequested��ֵ
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
