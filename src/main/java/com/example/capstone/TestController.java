package com.example.capstone;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    BucketRepo repo;

    @Autowired
    TransactionRepo trepo;

    @GetMapping("/test")
    public String testing() {
        return "Hello World";
    }

    @GetMapping("/getTransaction")
    public List<Transaction> getAllTransactions(){
        System.out.println(trepo.findAll());
        return trepo.findAll();
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
    @PutMapping("/editBucket/{id}")
    public void editBucket(@PathVariable Long id, @RequestBody Map<String, String> Data){
        Bucket bucket = repo.findById(id).get();
        
        Double percent = Double.parseDouble(Data.get("percent"));

        bucket.setPercent(percent);
        repo.save(bucket);
    }
}
