package com.example.exception.controller;

import com.example.exception.model.User;
import com.example.exception.model.UserTemp;
import com.example.exception.model.response.DataResponse;
import com.example.exception.repository.UserRepository;
import com.example.exception.repository.UserTempRepository;
import com.example.exception.service.MailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@Controller
public class UserController {

    @Autowired
    private UserTempRepository userTempRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailService mailService;


    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

// Các b lưu ý k code hết ở controller như mình nhé
    @PostMapping(value = "/checkOtp")
    @Transactional(rollbackOn =Exception.class)
    public String checkOtp(HttpServletRequest request, HttpSession session){
        Random random = new Random();
        int otp = random.nextInt(9999 - 1000 + 1) + 1000;
        UserTemp userTemp = new UserTemp();
        userTemp.setEmail(request.getParameter("email"));
        userTemp.setOtpCode(otp);
        //3*60*1000 = 3p
        userTemp.setExpiredTime(new Date(System.currentTimeMillis()+ 3*60*1000));
        userTempRepository.save(userTemp);
        // Mình thực hiện lưu dữ liệu vào session - session có thể lưu dữ liệu cho đến khi timeout
        session.setAttribute("userTemp", userTemp);
        mailService.sendEmail(userTemp.getEmail(),"OTP Received", "Your Otp code is: "+otp);
        return "otp";
    }

    // Các b lưu ý k code hết ở controller như mình nhé
    @ResponseBody
    @PostMapping(value = "/saveUser")
    public DataResponse saveUser(HttpServletRequest request, HttpSession session){

        // Đây là cách lấy dữ liệu ra từ session
        UserTemp userTempSession = (UserTemp) session.getAttribute("userTemp");
        System.out.println("email: "+userTempSession.getEmail());
        //UserTemp temp = userTempRepository.findByEmailAndOtpCode(userTempSession.getEmail(), userTempSession.getOtpCode());
        if( userTempSession.getExpiredTime().after(new Date(System.currentTimeMillis()))){
            String username = request.getParameter("username");
            System.out.println("Username: "+username);
            String password =  request.getParameter("password");
            User user = new User(username,userTempSession.getEmail(), password);
            System.out.println(user.toString());
            userRepository.save(user);
            userTempRepository.delete(userTempSession);
            return new DataResponse(HttpStatus.OK, "Register successfully");
        }
        return new DataResponse(HttpStatus.BAD_REQUEST, "Otp is expired");
    }
}
