package com.jin.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author JJLiu
 * @create 2021-03-31 10:34
 **/
@Service
public class ScheduledService {

    //cron表达式
    //秒 分 时 日 月 星期
    /*
        30 15 10 * * ? 每天的10点15分30秒执行一次
        30 0/5 10,18 * * ? 每天的10点和18点每隔5分钟执行一次
        0 15 10 ? * 1-6 每个月的周一到周六

     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void hello() {
        System.out.println("hello,你被执行了");
    }

}
