package com.example.capstone;
import java.util.UUID;
import javax.persistence.*;
//import org.springframework.data.annotation.Id;

public class Account {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    
    private String name;
    private long totalFunds;
    private String email;
    private String password;

    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public long getTotalFunds(){
        return this.totalFunds;
    }

    public void setName(long totalFunds){
        this.totalFunds = totalFunds;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
