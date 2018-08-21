package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.BankAccountQueries;
import com.amudhan.caveatemptor.dao.BankAccountDao;
import com.amudhan.caveatemptor.entity.BankAccount;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public BankAccount getBankAccount(long id) {
		return entityManager.find(BankAccount.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankAccount> getBankAccounts() {
		Query query = entityManager.createNamedQuery(BankAccountQueries.GETALLBANKACCOUNTS);
		return query.getResultList();
	}

	@Override
	public void persist(BankAccount bankAccount) {
		entityManager.persist(bankAccount);
	}

	@Override
	public void remove(BankAccount bankAccount) {
		entityManager.remove(bankAccount);
	}

}
