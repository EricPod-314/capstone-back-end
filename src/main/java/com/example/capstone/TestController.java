package com.example.capstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    BucketRepo repo;

    @GetMapping("/test")
    public String testing() {
        return "Hello World";
    }

    @GetMapping("/getAll")
    public List<Bucket> getAll() {
        return repo.findAll();
    }

    @PostMapping("/addOne")
    public void addOne(@RequestBody Bucket bucket) {
        repo.save(bucket);
    }

    @GetMapping("/getByAccountId/{id}")
    public List<Bucket> getById(@PathVariable Long id) {
        return repo.findByAccountId(id);
    }
}
