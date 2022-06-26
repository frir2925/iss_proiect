package com.example.proiectiss.Service;

import com.example.proiectiss.Domain.User;
import com.example.proiectiss.Repository.RepoUser;

public class UserService {
    private RepoUser userRepository;

    public UserService(RepoUser userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) {
        return userRepository.findOneByUsername(username);

    }

    public void save(User user) {
        userRepository.save(user);
    }

}
