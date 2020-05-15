package com.rookieqi.community.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("hello")
public class AlphaController {

    @GetMapping("world")
    public void Hello(ApplicationContext context){
        SimpleDateFormat format = context.getBean(SimpleDateFormat.class);
        System.out.println(format.format(new Date()));
    }
}
