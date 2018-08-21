package com.amudhan.caveatemptor.dao;

import com.amudhan.caveatemptor.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();

    public User getUser(long id);

    public void persist(User user);

    public void remove(User user);

    public void merge(User seller);
}
