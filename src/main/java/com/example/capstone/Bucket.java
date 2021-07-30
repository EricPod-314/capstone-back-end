package com.example.capstone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long accountId;
    private String name;
    private Double percent;
    private Long amountGoal;
    private Long amountSpent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPercent() {
        return percent;
    }
    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Long getAmountGoal() {
        return amountGoal;
    }

    public void setAmountGoal(Long amountGoal) {
        this.amountGoal = amountGoal;
    }

    public Long getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(Long amountSpent) {
        this.amountSpent = amountSpent;
    }

}
