package com.amudhan.caveatemptor.service;

import java.util.List;

import com.amudhan.caveatemptor.entity.User;

public interface UserService {
	public User getUser(long id);
	public List<User> getUsers();
	public void persist(User user);
	public void remove(User user);
}
