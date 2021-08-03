package com.example.capstone;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EditObject {
    private Long accountId;
    private Double income;
    private List<Bucket> buckets;


    public EditObject() {

    }

    public Double getIncome() {
        return this.income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public List<Bucket> getBuckets() {
        return this.buckets;
    }

    public void setBuckets(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
