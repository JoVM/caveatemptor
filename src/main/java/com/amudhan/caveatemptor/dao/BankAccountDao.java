package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.BankAccount;

public interface BankAccountDao {
	public BankAccount getBankAccount(long id);
	public List<BankAccount> getBankAccounts();
	public void persist(BankAccount bankAccount);
	public void remove(BankAccount bankAccount);
}
