package com.example.capstone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @GetMapping
    @RequestMapping("/test")
    public String testing() {
        return "Hello World";
    }

}
