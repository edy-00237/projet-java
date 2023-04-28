package com.example.quoteapp01.contoller;

import com.example.quoteapp01.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    public String hello(){
        return myService.sayHelo();
    }
}
