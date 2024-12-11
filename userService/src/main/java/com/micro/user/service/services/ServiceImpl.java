package com.micro.user.service.services;

import com.micro.user.service.entities.User;
import com.micro.user.service.exceptions.ResourceNotFoundException;
import com.micro.user.service.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public User updateUser(User user, String userId) {
        User existingUser = getUserById(userId);
        existingUser.setUserEmail(user.getUserEmail() != null ? user.getUserEmail() : existingUser.getUserEmail());
        existingUser.setUserName(user.getUserName() != null ? user.getUserName() : existingUser.getUserName());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        } else throw new RuntimeException("user not found with id " + userId);
    }
}
