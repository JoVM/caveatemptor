package com.amudhan.caveatemptor.service;

import java.util.List;

import com.amudhan.caveatemptor.entity.BankAccount;

public interface BankAccountService {
	public BankAccount getBankAccount(long id);
	public List<BankAccount> getBankAccounts();
	public void persist(BankAccount bankAccount);
	public void remove(BankAccount bankAccount);
}
