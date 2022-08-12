package com.rad.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rad.springboot.model.User;
import com.rad.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;    

    @Override
    public User save(User user) {
        user.setUsername("username1");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));        
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {       
                
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
       
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {

        User user =  userRepository.findByUsername(username).orElse(null);
        return user;
    }


}
