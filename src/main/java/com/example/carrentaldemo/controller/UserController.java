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
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobKOctets;
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
    public ResponseEntity<Object> createOwner(@RequestBody @Valid UserDto user){
        HashMap<String,String> validationMap=new HashMap<>();
        if(user.getRoleid()==0){
            validationMap.put("status","false");
            validationMap.put("message","Enter a valid Role");
            return new ResponseEntity<>(validationMap,HttpStatus.FORBIDDEN);
        }
        User owner =new User();
        Role role=roleRepository.findById(user.getRoleid()).get();
        if (role.getRoleName().equals("Owner")){
            owner.setRole(roleRepository.findById(user.getRoleid()).get());
        }
        else{
            validationMap.put("status","false");
            validationMap.put("message","Enter a valid Role");
            return new ResponseEntity<>(validationMap,HttpStatus.FORBIDDEN);
        }
        owner.setUsername(user.getUserName());
        owner.setAddress(user.getAddress());
        owner=userRepository.save(owner);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PostMapping("/users/hirer")
    public ResponseEntity<Object> createHirer(@Valid @RequestBody UserDto user){
        HashMap<String,String> validationMap=new HashMap<>();
        if(user.getRoleid()==0){
            validationMap.put("status","false");
            validationMap.put("message","Enter a valid Role");
            return new ResponseEntity<>(validationMap,HttpStatus.FORBIDDEN);
        }
        Role role=roleRepository.findById(user.getRoleid()).get();
        User hirer=new User();
        if(role.getRoleName().equals("Hirer")){
            hirer.setRole(roleRepository.findById(user.getRoleid()).get());
        }
        else{
            validationMap.put("status","false");
            validationMap.put("message","Enter a valid Role");
            return new ResponseEntity<>(validationMap,HttpStatus.FORBIDDEN);
        }
        hirer.setUsername(user.getUserName());
        hirer.setAddress(user.getAddress());
        hirer=userRepository.save(hirer);
        return new ResponseEntity<>(hirer,HttpStatus.OK);

    }
}
