package com.amudhan.caveatemptor.entity;

import com.amudhan.caveatemptor.constant.BankAccountQueries;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = BankAccountQueries.GETALLBANKACCOUNTS, query = BankAccountQueries.GETALLBANKACCOUNTS_Q)
})
@Entity
@Table(name = "bankaccount")
public class BankAccount extends BillingDetails {

    private static final long serialVersionUID = 1L;
    @Column(name = "accountnumber")
    @NotNull
    private String accountNumber;
    @Column(name = "bankname")
    @NotNull
    private String bankName;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}	
