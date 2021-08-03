package com.example.capstone;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    AccountRepo accountRepo;
  
    @Autowired
    TransactionRepo trepo;

  
    private static double roundToTwo(double value) {   
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    
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

    @PostMapping("/addTransaction")
    public void addTransaction(@RequestBody Transaction t){

        trepo.save(t);

    }

    @PutMapping("/editBucket/{id}")
    public void editBucket(@PathVariable Long id, @RequestBody Map<String, String> Data){
        Bucket bucket = repo.findById(id).get();

        Double percent = Double.parseDouble(Data.get("percent"));

        Account account = accountRepo.findById(bucket.getAccountId()).get();
        //Percent is stored as an int, must /100 for the math
        Double newGoal = account.getAmountForMonth() * (percent/100);
        Double rounded = roundToTwo(newGoal);


        bucket.setPercent(percent);
        bucket.setAmountGoal(rounded);
        repo.save(bucket);
    }
    

}
