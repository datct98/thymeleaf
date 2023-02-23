package com.example.exception.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "user_temp")
@Entity
public class UserTemp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private int otpCode;
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd hh:mm:ss")
    private Date expiredTime;
}
