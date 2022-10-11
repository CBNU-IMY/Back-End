package com.example.imy_server.Controller;

import com.example.imy_server.Domain.User;
import com.example.imy_server.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//page가 아닌 JSON을 리턴하기 위한 CONTROLLER
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // post로 사용자 추가 (회원가입)
    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 리스트 get
    @GetMapping("/user")
    public List findAll() {
        List<User> all = userRepository.findAll();
        return all;
    }
    @GetMapping("/test")
    public String test() {
        return "test complete";
    }

    //아이디로 찾기
    @GetMapping("/user/{user_id}")
    public Optional<User> findOne(@PathVariable Long user_id) {

        Optional<User> userOptional = userRepository.findById(user_id);
        return userOptional;
    }
    //회원삭제
    @DeleteMapping("/user")
    public void delete(@RequestParam Long user_id) {
        userRepository.deleteById(user_id);
    }

    //회원 수정
    //id로 회원정보 수정정
    @PutMapping("/user/{user_id}")
    public User update(@PathVariable Long user_id, @RequestParam Long user_pw, @RequestParam String user_name,
                       @RequestParam String user_phone) {
        Optional<User> user = userRepository.findById(user_id);

        //아이디를 바꾸어서는 안되니 id와 권한을 제외한 정보 변경
        User _user = user.get();
        _user.setUser_pw(user_pw);
        _user.setUser_name(user_name);
        _user.setUser_phone(user_phone);
        return userRepository.save(_user);

    }

}
