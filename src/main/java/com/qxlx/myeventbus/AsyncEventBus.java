package com.qxlx.myeventbus;

import java.util.concurrent.Executor;

/**
 * 定义异步的事件驱动
 */
public class AsyncEventBus extends EventBus {

    // 外部传入一个线程池
    public AsyncEventBus(Executor executor) {
        super(executor);
    }

}