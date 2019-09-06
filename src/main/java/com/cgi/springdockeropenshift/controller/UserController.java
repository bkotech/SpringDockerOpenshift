package com.cgi.springdockeropenshift.controller;

import com.cgi.springdockeropenshift.entity.User;
import com.cgi.springdockeropenshift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome() {
        String hello = "Hello CGI!";
        String swagger = "You can continue to <a href='/swagger-ui.html'>swagger</a>";
        return hello + "</br>" + swagger;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/first")
    public User getFirst() {
        return userRepository.findFirstByOrderByIdAsc();
    }

    @GetMapping("/last")
    public User getLast() {
        return userRepository.findFirstByOrderByIdDesc();
    }

    @GetMapping("/add")
    public List<User> users() {

        User last = userRepository.findFirstByOrderByIdDesc();
        int nextId = last != null ? last.getId() + 1 : 1;

        User users = new User();
        users.setId(nextId);
        users.setName("User" + nextId);
        users.setSalary(nextId * 1000);
        users.setTeam("Development" + nextId);

        userRepository.save(users);

        return userRepository.findAll();
    }

    @GetMapping("/delete")
    public List<User> deleteLast() {
        User last = userRepository.findFirstByOrderByIdDesc();
        userRepository.delete(last);
        return userRepository.findAll();
    }

}
