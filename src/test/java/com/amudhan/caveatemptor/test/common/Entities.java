package com.amudhan.caveatemptor.test.common;

import com.amudhan.caveatemptor.entity.*;
import com.amudhan.caveatemptor.entity.Address.AddressType;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.service.CategoryService;
import com.amudhan.caveatemptor.service.ItemService;
import com.amudhan.caveatemptor.service.UserService;
import com.amudhan.caveatemptor.utils.RandomAlphaGenerator;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Entities {

    @Inject
    private ItemService itemService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private UserService userService;
    private final RandomAlphaGenerator randomAlphaGenerator = new RandomAlphaGenerator();

    /*Common method that returns a fully initialized Seller*/
    /*Addresses, CreditCards, BankAccounts, Items are added to the Seller.
     * Bids and Images are added to Item.
     * All entities are dynamically generated except the bidder(User) that is added to the Item#bids#Bid*/
    public User getSeller() {
        User seller = new User();
        Name name = new Name();
        name.setFirstName(randomAlphaGenerator.randomString());
        name.setLastName(randomAlphaGenerator.randomString());
        seller.setName(name);
        Item item = getItem();
        Image image = getImage();
        Bid bid = getBid();
        Address billingAddress = getAddress();
        Address shippingAddress = getAddress();
        CreditCard creditCard = getCreditCard();
        BankAccount bankAccount = getBankAccount();
        Category category = categoryService.getCategory(10000001);
        Set<Item> sellingItems = new HashSet<Item>();
        Set<Image> images = new HashSet<Image>();
        Set<Address> addresses = new HashSet<Address>();
        Set<CreditCard> creditCards = new HashSet<CreditCard>();
        Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
        Set<Bid> bids = new HashSet<Bid>();
        billingAddress.setAddressType(AddressType.BILLING);
        billingAddress.setUser(seller);
        shippingAddress.setAddressType(AddressType.SHIPPING);
        shippingAddress.setUser(seller);
        addresses.add(billingAddress);
        addresses.add(shippingAddress);
        creditCard.setOwner(seller);
        bankAccount.setOwner(seller);
        creditCards.add(creditCard);
        bankAccounts.add(bankAccount);
        seller.setAddresses(addresses);
        seller.setCreditCards(creditCards);
        seller.setBankAccounts(bankAccounts);
        image.setItem(item);
        images.add(image);
        bid.setBidder(userService.getUser(10000001));
        bid.setItem(item);
        bids.add(bid);
        seller.setUserType(UserType.SELLER);
        item.setSeller(seller);
        item.setImages(images);
        item.setCategory(category);
        item.setBids(bids);
        sellingItems.add(item);
        seller.setSellingItems(sellingItems);
        return seller;
    }

    /*Common method that returns a fully initialized Buyer*/
    /*All entities are newly created except Item*/
    public User getBuyer() {
        User buyer = new User();
        Name name = new Name();
        name.setFirstName(randomAlphaGenerator.randomString());
        name.setLastName(randomAlphaGenerator.randomString());
        buyer.setName(name);
        Bid bid = getBid();
        Address billingAddress = getAddress();
        Address shippingAddress = getAddress();
        CreditCard creditCard = getCreditCard();
        BankAccount bankAccount = getBankAccount();
        Set<Address> addresses = new HashSet<Address>();
        Set<CreditCard> creditCards = new HashSet<CreditCard>();
        Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
        Set<Bid> bids = new HashSet<Bid>();
        billingAddress.setAddressType(AddressType.BILLING);
        billingAddress.setUser(buyer);
        shippingAddress.setAddressType(AddressType.SHIPPING);
        shippingAddress.setUser(buyer);
        addresses.add(billingAddress);
        addresses.add(shippingAddress);
        creditCard.setOwner(buyer);
        bankAccount.setOwner(buyer);
        creditCards.add(creditCard);
        bankAccounts.add(bankAccount);
        bid.setItem(itemService.getItem(10000001));
        bids.add(bid);
        bid.setBidder(buyer);
        buyer.setUserType(UserType.BUYER);
        buyer.setAddresses(addresses);
        buyer.setCreditCards(creditCards);
        buyer.setBankAccounts(bankAccounts);
        buyer.setBids(bids);
        return buyer;
    }

    public Item getItem() {
        Item item = new Item();
        item.setName(randomAlphaGenerator.randomString());
        item.setDescription(randomAlphaGenerator.randomString());
        item.setInitialPrice(new BigDecimal(randomAlphaGenerator.randomInt(500, 10000)));
        return item;
    }

    public Bid getBid() {
        Bid bid = new Bid();
        bid.setAmount(new BigDecimal(randomAlphaGenerator.randomInt(500, 10000)));
        bid.setCreatedOn(LocalDateTime.now());
        return bid;
    }

    public Address getAddress() {
        Address address = new Address();
        address.setBuilding(randomAlphaGenerator.randomAlpha());
        address.setStreet(randomAlphaGenerator.randomString());
        address.setZipCode(randomAlphaGenerator.randomNumbersOfDigits(6));
        address.setCity(randomAlphaGenerator.randomString());
        return address;
    }

    public Image getImage() {
        Image image = new Image();
        image.setImageUrl("/resources/images/" + randomAlphaGenerator.randomString());
        image.setName(randomAlphaGenerator.randomString());
        return image;
    }

    public CreditCard getCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCreditCardNumber(randomAlphaGenerator.randomNumbersOfDigits(16));
        creditCard.setExpiryYear(new Integer(randomAlphaGenerator.randomInt(17, 50)).toString());
        creditCard.setExpiryMonth(new Integer(randomAlphaGenerator.randomInt(1, 12)).toString());
        return creditCard;
    }

    public BankAccount getBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(randomAlphaGenerator.randomNumbersOfDigits(16));
        bankAccount.setBankName(randomAlphaGenerator.randomString());
        return bankAccount;
    }

    public Category getCategory() {
        Category category = new Category();
        category.setName(randomAlphaGenerator.randomString());
        return category;
    }
}
