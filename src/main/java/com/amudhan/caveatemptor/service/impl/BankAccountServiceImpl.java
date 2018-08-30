package com.amudhan.caveatemptor.service.impl;

import com.amudhan.caveatemptor.dao.BankAccountDao;
import com.amudhan.caveatemptor.entity.BankAccount;
import com.amudhan.caveatemptor.service.BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {

    @Inject
    private BankAccountDao bankAccountDao;

    @Override
    public BankAccount getBankAccount(long id) {
        return bankAccountDao.getBankAccount(id);
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return bankAccountDao.getBankAccounts();
    }

    @Override
    public void persist(BankAccount bankAccount) {
        bankAccountDao.persist(bankAccount);
    }

    @Override
    public void remove(BankAccount bankAccount) {
        bankAccountDao.remove(bankAccount);
    }

}
