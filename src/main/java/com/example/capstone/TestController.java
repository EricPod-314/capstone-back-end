package com.example.capstone;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{

    @Autowired
    BucketRepo bucketRepo;

    @GetMapping
    @RequestMapping("/test")
    public String testing() {
        return "Hello World";
    }

    @GetMapping("/account/getAllBuckets/{id}")
    public List<Bucket> getAccountId(@PathVariable UUID id){
        
    }

}
