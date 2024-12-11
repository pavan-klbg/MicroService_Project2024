package com.micro.user.service.services;

import com.micro.user.service.entities.User;

import java.util.List;

public interface IUserService {
    // to save one specfic user
    User saveUser(User user);

    // to fetch all users list
    List<User> getAllUsers();

    // get user by id
    User getUserById(String userId);

    // update user details
    User updateUser(User user, String userId);

    //delete user by id
    public void deleteUser(String userId);


}
