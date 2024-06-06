package com.example.user.service.dao;

import com.example.user.service.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(String id);
    List<User> getAllUser();
    List<User> getUserByEmail(String email);
    void createUser(User user);

    List<User> getUserByName(String name);

//    List<User> getUserByEmail2(String email);
//    public List<User> getUserByEmail3(String email);
}
