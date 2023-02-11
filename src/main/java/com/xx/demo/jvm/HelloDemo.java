package com.xx.demo.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: springboot-essay
 * @description:
 * @author: 北京小桔汇金网络科技有限公司
 * @date: 2023/02/11 13:18
 */
@RestController
public class HelloDemo {
    @GetMapping("/hello")
    public  String hello(){
        return "hello Springboot";
    }
}
