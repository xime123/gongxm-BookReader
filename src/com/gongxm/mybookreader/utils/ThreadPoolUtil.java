package com.gongxm.mybookreader.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * �̳߳ع�����
 * @author gongxm
 *
 */
public class ThreadPoolUtil {
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(20);
	
	/**
	 * ���̳߳���ȡһ���߳�ִ���������
	 * @param task
	 */
	public static void executeOnNewThread(Runnable task){
		threadPool.submit(task);
	}

}
