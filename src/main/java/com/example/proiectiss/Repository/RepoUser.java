package com.example.proiectiss.Repository;

import com.example.proiectiss.Domain.User;

public interface RepoUser extends Repository<Long, User> {

    public User findOneByUsername(String Username);

}