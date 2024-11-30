package com.qxlx.myeventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 事件监听器 核心类
 * 1.完成注册
 * 2.完成匹配
 */
public class ObserverRegistry {

    // 核心数据结构
    // key 存储事件类型,value 存储一个集合
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        // 获取带有注解的@Subscribe注解的方法 封装的集合类
        // key是方法的参数 也就是事件类型, value是observer
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        // 便利处理 所有方法
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            // 获取事件类型
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            // 如果为空 创建一个集合 这里使用CopyOnWriteArraySet 写时复制技术
            if (registeredEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            // 把对应的observer添加到集合中
            registeredEventActions.addAll(eventActions);
        }
    }

    /**
     * 获取所有匹配的事件
     * @param event
     * @return
     */
    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        // 根据参数类型获取
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            // 判断是否存在继承关系
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();

        // 获取当前类
        Class<?> clazz = observer.getClass();
        // 对所有包含@Subscribe注解的方法处理
        for (Method method : getAnnotatedMethods(clazz)) {
            // 获取参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            // 获取第一个参数
            Class<?> eventType = parameterTypes[0];
            // 如果不包含 new ArrayList()
            if (!observerActions.containsKey(eventType)) {
                // key 是当前对象方法的参数
                observerActions.put(eventType, new ArrayList<>());
            }
            // value是当前对象和方法 封装的 observer
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        // 一个类可能有多个方法带有@Subscribe注解
        for (Method method : clazz.getDeclaredMethods()) {
            // 包含有注解 添加到集合中
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}