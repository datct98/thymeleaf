package com.example.exception.controller;


import com.example.exception.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;

    @GetMapping(value = "/sendMail")
    public String testGmail(){
        mailService.sendEmail("mikechael74@gmail.com", "Test Email", "Haha");
        return "Send success";
    }
}
