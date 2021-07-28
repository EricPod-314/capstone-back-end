package com.example.capstone;
import java.util.UUID;
import javax.persistence.*;

public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

}
