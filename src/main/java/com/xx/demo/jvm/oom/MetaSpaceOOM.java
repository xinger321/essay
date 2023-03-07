package com.xx.demo.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @title: springboot-essay
 * @description: 元空间oom-cglib生成大量类
 * 限制 metaspace空间大小看jvm oom
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2023/02/11 13:20
 */
public class MetaSpaceOOM {
    public static void log(){
        try{
            //将日志写入es集群
        }catch(Exception e){
            log();
        }
    }
    public static void main(String[] args) {
        try{
            //一大堆的业务逻辑
            log();
        }catch(Exception e){
            log();
        }
        
        long count = 0;
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);

                    //if (method.getName().equals("run")){
                    //    System.out.println("启动汽车之前，先进行自动的安全检查");
                    //    return methodProxy.invokeSuper(o,objects);
                    //}else {
                    //    return methodProxy.invokeSuper(o,objects);
                    //}
                }
            });
            Car car = (Car) enhancer.create();
            car.run();
            System.out.println("目前已创建"+ (++count) +"个car类的子类");
        }
    }
    
    static class Car{
        public void run(){
            System.out.println("汽车启动，开始行驶......");
        }
    }
}
