package com.example.exception.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private Date birthDate;
    private boolean gender;
    private String email;
    private String phone;
    private int experience;
}
