package com.example.exception.repository;

import com.example.exception.model.UserTemp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTempRepository extends JpaRepository<UserTemp, Integer> {
    UserTemp findByEmailAndOtpCode(String email, int otp);
}
