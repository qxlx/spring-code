package com.qxlx.myeventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 事件类
 */
public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    /**
     * 注册一个事件监听者
     * @param object
     */
    public void register(Object object) {
        // 核心还是添加到集合中
        registry.register(object);
    }

    /**
     * 执行一个事件类
     * @param event
     */
    public void post(Object event) {
        // 获取事件对应的监听者
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        // 直接执行
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}