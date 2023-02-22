package com.example.exception.controller;

import com.example.exception.exception.NotFoundException;
import com.example.exception.model.Person;
import com.example.exception.model.response.DataResponse;
import com.example.exception.repository.PersonRepository;
import com.example.exception.service.MailService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MailService mailService;

    @ResponseBody
    @GetMapping(value = "/person/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable int id){
        Person person = personRepository.findById(id);
        if(person==null) throw new NotFoundException("Not found id: "+id);
        return ResponseEntity.ok(person);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<DataResponse> deletePersonById(@PathVariable int id){
        Person person = personRepository.findById(id);
        if(person==null) return ResponseEntity.ok(new DataResponse(HttpStatus.NOT_FOUND, "Không tìm thấy id: "+id));
        return ResponseEntity.ok(new DataResponse(HttpStatus.OK,"Delete successfully"));
    }

    @GetMapping(value = "/home")
    public String homePage(Model model){
        Person person = personRepository.findById(1);
        if(person==null) throw new NotFoundException("Not found id: "+1);
        List<Person> people = personRepository.findAll();

        model.addAttribute("people", people);
        return "index";
    }
    @GetMapping(value = "/form")
    public String formApply(Model model){
        Person person = personRepository.findById(1);
        model.addAttribute("user", person);
        return "main.html";
    }

    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new Person());
        return "main";
    }

    @PostMapping("/users/save")
    public String saveUser(@ModelAttribute("user") Person user) {
        personRepository.save(user);
        return "redirect:/users";
    }
    @GetMapping(value = "/users")
    public String getUsersByPage(Model model, HttpServletRequest request,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "4") int size) {
        Page<Person> users = personRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("users", users);
        return "users";
    }
}
