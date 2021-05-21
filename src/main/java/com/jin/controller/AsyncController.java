package com.jin.controller;

import com.jin.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JJLiu
 * @create 2021-03-29 10:33
 **/
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        asyncService.hello();
        return "ok";
    }

}
