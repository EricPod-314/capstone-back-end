package com.example.capstone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=999, allocationSize=1)
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;
    private Long accountId;
    private String name;
    private Double percent;
    private Double amountGoal;
    private Double amountSpent;

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

    public Double getAmountGoal() {
        return amountGoal;
    }

    public void setAmountGoal(Double amountGoal) {
        this.amountGoal = amountGoal;
    }

    public Double getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(Double amountSpent) {
        this.amountSpent = amountSpent;
    }

}
