package com.jin.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author JJLiu
 * @create 2021-03-29 10:24
 **/
@Service
public class AsyncService {

    //告诉Spring这是一个异步的方法
    @Async
    public void hello() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("123");
        System.out.println("数据正在处理...");
    }

}
