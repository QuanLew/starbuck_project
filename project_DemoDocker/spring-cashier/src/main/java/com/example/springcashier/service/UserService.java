package com.example.springcashier.service;

import com.example.springcashier.entity.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);

    public List<User> getAllUser();

    public User getUserByEmail(String email);
}