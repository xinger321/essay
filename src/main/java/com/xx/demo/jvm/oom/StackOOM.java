package com.xx.demo.jvm.oom;

/**
 * @title: springboot-essay
 * @description: 栈oom
 * -XX:ThreadStackSize=1m 设置jvm 栈内存大小为1M
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2023/02/11 13:52
 */
public class StackOOM {
    public static long count = 0;
    public static void main(String[] args) {
        work();
    }
    public static void work(){
        System.out.println("目前是第"+ (++count) +"次调用方法");
        work();
    }
}
