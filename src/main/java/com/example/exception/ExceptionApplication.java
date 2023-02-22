package com.example.exception;

import com.example.exception.model.Person;
import com.example.exception.model.Wallet;
import com.example.exception.repository.PersonRepository;
import com.example.exception.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ExceptionApplication implements CommandLineRunner {
@Autowired
private PersonRepository personRepository;
@Autowired
private WalletRepository walletRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Wallet wallet = new Wallet("12345", 20000);
        Wallet wallet2 = new Wallet("54321", 40000);
        walletRepository.saveAll(Arrays.asList(wallet, wallet2));*/

    }
}
