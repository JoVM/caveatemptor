package com.amudhan.caveatemptor.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;
	
	@Override
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public void persist(User user) {
		userDao.persist(user);
	}

	@Override
	public void remove(User user) {
		userDao.remove(user);
	}

}
