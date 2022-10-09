package com.example.g_server.Controller;


import com.example.g_server.Domain.User;
import com.example.g_server.Repository.JpaUserRepository;
import com.example.g_server.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//page가 아닌 JSON을 리턴하기 위한 CONTROLLER
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.sign_up(user);
    }

    @GetMapping("/user")
    public String read(@PathVariable int user_id) {

        Optional<User> userOptional = userRepository.findById(user_id);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
    @GetMapping("/user/test")
    public List test() {

        List<User> all = userRepository.findAll();
        return all;



    }

}
