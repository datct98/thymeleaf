package com.example.exception.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@Table
@Entity
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNum;
    private double balance;

    public Wallet(String accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }
}
