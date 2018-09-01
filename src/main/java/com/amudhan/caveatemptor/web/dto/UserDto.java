package com.amudhan.caveatemptor.web.dto;

import com.amudhan.caveatemptor.entity.*;

import java.util.Set;

/*
 * User - A user can be a seller or a buyer.
 * Name - A value type that represents firstName and lastName.
 * Sellers - One seller can have multiple selling items.
 * Buyers - One buyer can have multiple bids on different items.
 * Address- A user can have multiple addresses with types BILLING and SHIPPING.
 * Billing details - A user can have multiple billing details of types BANKACCOUNT and CREDITCARD.
 * CascadeType.ALL -
 * */
public class UserDto {

    private Name name;

    private User.UserType userType;

    private Integer age;

    private Set<Item> sellingItems;

    private Set<Address> addresses;

    private Set<CreditCard> creditCards;

    private Set<BankAccount> bankAccounts;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Item> getSellingItems() {
        return sellingItems;
    }

    public void setSellingItems(Set<Item> sellingItems) {
        this.sellingItems = sellingItems;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
