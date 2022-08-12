package com.rad.springboot.service;

import java.util.List;

import com.rad.springboot.model.User;

public interface UserService {
    
    public User save(User user);

    public List<User> findAll();

    public void deleteById(Long id);

    public User findByUsername(String username);
}
