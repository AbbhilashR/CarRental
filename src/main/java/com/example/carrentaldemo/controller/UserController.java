package com.example.carrentaldemo.controller;


import com.example.carrentaldemo.model.Role;
import com.example.carrentaldemo.model.User;
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
    public ResponseEntity<User> createOwner(@Valid @RequestBody  User user){
        System.out.println(user);

//        userService.findById(roleid).
//
//        System.out.println(role);
//     System.out.println(role.getClass().getName());
//        if(!role.equals("Owner")){
//            System.out.println("Success , we failed -- the role is not owner");
//            HashMap<String,String> ownerValidation=new HashMap<>();
//            ownerValidation.put("status","false");
//            ownerValidation.put("message","Enter a Valid role,the Entered role is not owner");
//            return new ResponseEntity<>(ownerValidation,HttpStatus.FORBIDDEN);
//        }
        HashMap<String,String> validationSuccessful=new HashMap<>();
        validationSuccessful.put("status","false");
        User us1=userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
