package com.amudhan.caveatemptor.test.dao;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.test.DaoTest;
import com.amudhan.caveatemptor.test.common.Entities;
import com.amudhan.caveatemptor.test.common.Validator;

public class UserDaoTest extends DaoTest {

	@Inject
	private UserDao userDao;
	@Inject
	private Entities entities;
	@Inject
	private Validator validator;
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	/*TC1: Create seller"*/
	@Test
	public void createSeller(){
		logger.info("createSeller starting--------------------------------------------");
		User seller = entities.getSeller();
		/*
		 * CascadeType is ALL. Address, BankAccount, CreditCard, Item, Image are all persisted along with User.
		 * 
		 * */
		userDao.persist(seller);
		entityManager.flush();
		User persistedUser = userDao.getUser(seller.getId());
		validator.checkPersistedUser(persistedUser);
	}
	/*TC2: Remove seller*/
	@Test
	public void removeSeller(){
		logger.info("removeSeller starting--------------------------------------------");
		User seller = entities.getSeller();
		userDao.persist(seller);
		entityManager.flush();
		User persistedSeller = userDao.getUser(seller.getId());
		userDao.remove(seller);
		entityManager.flush();
		validator.checkRemovedUser(persistedSeller);
	}
	/*TC3: Create buyer*/
	@Test
	public void createBuyer(){
		logger.info("createBuyer starting--------------------------------------------");
		User buyer = entities.getBuyer();
		buyer.setUserType(UserType.BUYER);
		userDao.persist(buyer);
		entityManager.flush();
		User persistedUser = userDao.getUser(buyer.getId());
		validator.checkPersistedUser(persistedUser);
	}
	/*TC4: Remove buyer*/
	@Test
	public void removeBuyer(){
		logger.info("removeBuyer starting--------------------------------------------");
		User buyer = entities.getBuyer();
		userDao.persist(buyer);
		entityManager.flush();
		User persistedBuyer = userDao.getUser(buyer.getId());
		userDao.remove(buyer);
		entityManager.flush();
		validator.checkRemovedUser(persistedBuyer);
	}
}
