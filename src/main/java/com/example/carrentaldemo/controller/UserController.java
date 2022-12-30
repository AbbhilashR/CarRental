package com.example.carrentaldemo.controller;


import com.example.carrentaldemo.model.Role;
import com.example.carrentaldemo.model.User;
import com.example.carrentaldemo.model.UserDto;
import com.example.carrentaldemo.repository.RoleRepository;
import com.example.carrentaldemo.repository.UserRepository;
import com.example.carrentaldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    //    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//       User savedUser = userService.createUser(user);
//        System.out.println(savedUser);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
    @GetMapping("/users")
    public List getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/users/owner")
    public ResponseEntity<User> createOwner(@RequestBody UserDto user){
        System.out.println("we are inside ,Validation done");
        HashMap<String,String> validationSuccessful=new HashMap<>();
        validationSuccessful.put("status","True");
//        User us1=userService.createUser(user);
        User u1 =new User();
        u1.setRole(roleRepository.findById(user.getRoleid()).get());
        u1.setUsername(user.getUserName());
        u1.setAddress(user.getAddress());
        u1=userRepository.save(u1);
        return new ResponseEntity<User>(u1, HttpStatus.OK);

    }
}
