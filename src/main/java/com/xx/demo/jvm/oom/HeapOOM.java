package com.xx.demo.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: springboot-essay
 * @description: 堆oom
 * -Xms10m -Xmx10m 设置jvm堆内存为 10m
 * 在堆内存设置为10m大小的情况下，简单的object对象创建，大概需要36万个 会造成老年代塞满，进而oom
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2023/02/11 13:57
 */
public class HeapOOM {
    public static void main(String[] args) {
        long count = 0;
        List<Object> list = new ArrayList<>();
        while (true){
            list.add(new Object());
            System.out.println("目前是第"+ (++count) +"个对象创建");
        }
    }
}
