package com.example.task7_boot.service;

import com.example.task7_boot.models.User;
import com.example.task7_boot.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepositories userRepositories;

    @Autowired
    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public List<User> getAll() {
        return userRepositories.findAll();
    }

    public User getById(int id) {
        Optional<User> userOptional = userRepositories.findById(id);
        return userOptional.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepositories.save(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        userRepositories.save(updateUser);
    }

    @Transactional
    public void delete(int id) {
        userRepositories.deleteById(id);
    }
}