package com.example.carrentaldemo.service;

import com.example.carrentaldemo.model.Role;
import com.example.carrentaldemo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


}
