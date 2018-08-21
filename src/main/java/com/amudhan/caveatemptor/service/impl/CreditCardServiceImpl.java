package com.amudhan.caveatemptor.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.CreditCardDao;
import com.amudhan.caveatemptor.entity.CreditCard;
import com.amudhan.caveatemptor.service.CreditCardService;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

	@Inject
	private CreditCardDao creditCardDao;
	
	@Override
	public void persist(CreditCard creditCard) {
		creditCardDao.persist(creditCard);
	}

	@Override
	public void remove(CreditCard creditCard) {
		creditCardDao.remove(creditCard);
	}

	@Override
	public CreditCard getCreditCard(long id) {
		return creditCardDao.getCreditCard(id);
	}

	@Override
	public List<CreditCard> getCreditCards() {
		return creditCardDao.getCreditCards();
	}

}
