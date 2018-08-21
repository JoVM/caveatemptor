package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.CreditCardQueries;
import com.amudhan.caveatemptor.dao.CreditCardDao;
import com.amudhan.caveatemptor.entity.CreditCard;

@Repository
public class CreditCardDaoImpl implements CreditCardDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CreditCard getCreditCard(long id) {
		return entityManager.find(CreditCard.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditCard> getCreditCards() {
		Query query = entityManager.createNamedQuery(CreditCardQueries.GETALLCREDITCARDS);
		return query.getResultList();
	}

	@Override
	public void persist(CreditCard creditCard) {
		entityManager.persist(creditCard);
	}

	@Override
	public void remove(CreditCard creditCard) {
		entityManager.remove(creditCard);
	}
	
}
