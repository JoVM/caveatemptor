package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.CreditCard;

public interface CreditCardDao {
	public CreditCard getCreditCard(long id);
	public List<CreditCard> getCreditCards();
	public void persist(CreditCard creditCard);
	public void remove(CreditCard creditCard);
}
