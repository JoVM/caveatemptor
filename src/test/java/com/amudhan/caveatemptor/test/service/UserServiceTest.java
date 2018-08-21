package com.amudhan.caveatemptor.test.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.service.UserService;
import com.amudhan.caveatemptor.test.ServiceTest;

public class UserServiceTest extends ServiceTest{
	@Inject
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
		
	@Test
	void getUsers(){
		List<User> users = userService.getUsers();
		Assert.assertNotNull(users);
		for(User user:users){
			logger.info(user.getId()+" "+user.getName().getFirstName()+" "+user.getName().getLastName());
		}
	}
	
	@Test
	void getUser(){
		User user = userService.getUser(10000001);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getId(), 10000001);
		Assert.assertEquals(user.getUserType(), User.UserType.BUYER);
		Assert.assertEquals("James",user.getName().getFirstName());
		Assert.assertEquals("Bond",user.getName().getLastName());
		logger.info(user.getId()+" "+user.getName().getFirstName()+" "+user.getName().getLastName());
	}
	
}
