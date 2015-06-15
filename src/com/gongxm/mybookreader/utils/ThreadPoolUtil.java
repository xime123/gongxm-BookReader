package com.gongxm.mybookreader.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 线程池工具类
 * @author gongxm
 *
 */
public class ThreadPoolUtil {
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(20);
	
	/**
	 * 从线程池中取一个线程执行这个任务
	 * @param task
	 */
	public static void executeOnNewThread(Runnable task){
		threadPool.submit(task);
	}

}
