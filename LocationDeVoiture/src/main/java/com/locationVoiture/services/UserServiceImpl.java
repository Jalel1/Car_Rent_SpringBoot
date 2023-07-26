package com.locationVoiture.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.locationVoiture.entities.Role;
import com.locationVoiture.entities.User;
import com.locationVoiture.repositories.RoleRepository;
import com.locationVoiture.repositories.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   
    public void save(User user) {
    	String oldpassword = user.getPassword();
    	String newPassword = bCryptPasswordEncoder.encode(oldpassword);
    	
        user.setPassword(newPassword);
        
        user.setRoles(new HashSet<Role>(roleRepository.findAll()));
        userRepository.save(user);
    }

  
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
