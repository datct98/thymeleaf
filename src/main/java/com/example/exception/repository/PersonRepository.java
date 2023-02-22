package com.example.exception.repository;

import com.example.exception.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findById(int id);
}
