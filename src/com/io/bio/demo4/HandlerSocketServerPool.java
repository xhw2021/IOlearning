package com.io.bio.demo4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 22936
 * @CreateTime: 2021-05-03 21:23
 * @Description: 创建线程池
 */
public class HandlerSocketServerPool {
    private ExecutorService executorService;

    //初始化线程池对象
    public HandlerSocketServerPool(int maxThreadNum,int queueSize) {
        executorService = new ThreadPoolExecutor(3,maxThreadNum,
                120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    // 提供一个方法来提交任务给线程池的任务队列进行处理，等待线程池来处理

    public void execute(Runnable target){
        executorService.execute(target);
    }
}
