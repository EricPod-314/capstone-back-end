package com.example.capstone;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    //Rounding function (Used in edit bucket mapping)
    private static double roundToTwo(double value) {   
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
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
        //Date Formating
        String date = t.getDate();
        String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8,10);
        String newstring = month + "/" + day + "/" + year;

        t.setDate(newstring);
        trepo.save(t);
        
        //update the amount spent with new transaction
        List<Bucket> buckets = repo.findByAccountId(t.getAccountId());
        for(Bucket bucket : buckets) {
            if(bucket.getName().equals(t.getBucketTag())) {
                bucket.setAmountSpent(bucket.getAmountSpent() + t.getAmount());
                repo.save(bucket);
                break;
            }
        }

    }

    @PutMapping("/editBucket")
    public void editBucket(@RequestBody EditObject data){
        
        //Grab Account
        if (data.getIncome() != 0) {
            Account account = accountRepo.getById(data.getAccountId());
            account.setAmountForMonth(data.getIncome());//update the budget with income
            accountRepo.save(account);

            List<Bucket> buckets = repo.findAll();
            for(Bucket bucket : buckets) {
                bucket.setAmountGoal(data.getIncome() * (bucket.getPercent()/100) );//Set each bucket's budget amount with percentage
                repo.save(bucket);
            }
        }

        //Updating each bucket that was edited
        for(Bucket object : data.getBuckets()){

           if(object.getPercent() == null) {
                continue;
            }

            Bucket bucket = repo.findById(object.getId()).get();

            Double percent = object.getPercent();


            Account account = accountRepo.findById(data.getAccountId()).get();
            //Percent is stored as an int, must /100 for the math
            Double newGoal = account.getAmountForMonth() * (percent/100);
            Double rounded = roundToTwo(newGoal);
    
            
            bucket.setPercent(percent);
            bucket.setAmountGoal(rounded);
            repo.save(bucket);

        }

    }
    @PostMapping("/newSpendingMonth")
    public void newSpendingMonth(@RequestBody Account data){
        Long accountId = data.getId();
        List<Bucket> buckets = repo.findByAccountId(accountId);
        for(Bucket i: buckets){
            //reset the spent data for buckets
            i.setAmountSpent(0.0);
            repo.save(i);
        }
    }

    @PostMapping("/addNewBucket")
    public void addNewBucket(@RequestBody Bucket bucket) {
        repo.save(bucket);
    }
    
    @DeleteMapping("/deleteBucket")
    public void deleteBucket(@RequestBody Bucket bucket) {
        repo.deleteById(bucket.getId());
    }

}
