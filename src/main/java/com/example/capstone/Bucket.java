package com.example.capstone;

import javax.persistence.GeneratedValue;

import java.util.UUID;

import javax.persistence.*;

public class Bucket {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    private String tag;
    private double percent;
    private long amount;
    private UUID accountId;

    public Bucket(String tag, double percent, long amount, UUID accountId){
        this.tag = tag;
        this.percent = percent;
        this.amount = amount;
        this.accountId = accountId;
    }

    public String getTag(){
        return this.tag;
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    public double getPercent(){
        return this.percent;
    }

    public void setPercent(double percent){
        this.percent = percent;
    }

    public long getAmount(){
        return this.amount;
    }

    public void setAmount(long amount){
        this.amount = amount;
    }

    public UUID getAccountId(){
        return this.accountId;
    }

    public void setAccountId(UUID accountId){
        this.accountId = accountId;
    }
}
