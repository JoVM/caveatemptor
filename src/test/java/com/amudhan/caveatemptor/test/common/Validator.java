package com.amudhan.caveatemptor.test.common;

import com.amudhan.caveatemptor.entity.*;
import com.amudhan.caveatemptor.entity.User.UserType;
import com.amudhan.caveatemptor.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import javax.inject.Inject;

public class Validator {

    @Inject
    private UserService userService;
    @Inject
    private ItemService itemService;
    @Inject
    private ImageService imageService;
    @Inject
    private AddressService addressService;
    @Inject
    private CreditCardService creditCardService;
    @Inject
    private BankAccountService bankAccountService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private BidService bidService;
    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    public boolean checkPersistedUser(User persistedUser) {
        Assert.assertNotNull(persistedUser);
        Assert.assertNotNull(persistedUser.getUserType());
        logger.info("Details for the user: " + persistedUser.getName().getFirstName() + " " +
                persistedUser.getName().getLastName() + " ID" + persistedUser.getId() + " Usertype: " + persistedUser.getUserType());
        Assert.assertNotNull(persistedUser.getAddresses());
        for (Address address : persistedUser.getAddresses()) {
            checkPersistedAddress(address);
        }
        Assert.assertNotNull(persistedUser.getCreditCards());
        for (CreditCard creditCard : persistedUser.getCreditCards()) {
            checkPersistedCreditCard(creditCard);
        }
        Assert.assertNotNull(persistedUser.getBankAccounts());
        for (BankAccount bankAccount : persistedUser.getBankAccounts()) {
            checkPersistedBankAccount(bankAccount);
        }
        if (persistedUser.getUserType().equals(UserType.SELLER)) {
            for (Item item : persistedUser.getSellingItems()) {
                checkPersistedItem(item);
            }
        } else if (persistedUser.getUserType().equals(UserType.BUYER)) {
            for (Bid bid : persistedUser.getBids()) {
                checkPersistedBid(bid);
            }
        }

        return true;
    }

    public boolean checkPersistedItem(Item persistedItem) {
        Assert.assertNotNull(persistedItem);
        logger.info("Item details: Item ID: " + persistedItem.getId() + " Item name: " + persistedItem.getName());
        User seller = persistedItem.getSeller();
        Assert.assertNotNull(seller);
        logger.info("Seller details: Seller ID: " + seller.getId() + " Seller Name: " + seller.getName().getFirstName() + "" + seller.getName().getLastName());
        Assert.assertNotNull(persistedItem.getBids());
        for (Bid bid : persistedItem.getBids()) {
            logger.info("Bid details: Bid ID " + bid.getId() + " Bidder ID: " + bid.getBidder().getId() + " Bidder name: " +
                    bid.getBidder().getName());
        }
        Assert.assertNotNull(persistedItem.getImages());
        for (Image image : persistedItem.getImages()) {
            logger.info("Image details: Image ID: " + image.getId() + " Image name " + image.getName());
        }
        if (persistedItem.getCategory() != null) {
            Assert.assertNotNull(persistedItem.getCategory());
            logger.info("Category details: Category ID: " + persistedItem.getCategory().getId() + " Category name " + persistedItem.getCategory().getName());
        }
        return true;
    }

    public boolean checkPersistedBid(Bid bid) {
        Assert.assertNotNull(bid);
        Assert.assertNotNull(bid.getBidder());
        Assert.assertNotNull(bid.getItem());
        logger.info("Bid details: Bid ID: " + bid.getId() + " Bidder ID " + bid.getBidder().getId() +
                " Bidder name " + bid.getBidder().getName().getFirstName() + " " + bid.getBidder().getName().getLastName());
        logger.info("Bidded item ID :" + bid.getItem().getId() + " Item name " + bid.getItem().getName());
        return true;
    }

    public boolean checkPersistedImage(Image image) {
        Assert.assertNotNull(image);
        Assert.assertNotNull(image.getItem());
        logger.info("Image ID :" + image.getId() + " Image name " + image.getName() + " Item ID: " + image.getItem().getId() + " " +
                image.getItem().getName());
        return true;
    }

    public boolean checkPersistedAddress(Address address) {
        Assert.assertNotNull(address);
        Assert.assertNotNull(address.getUser());
        logger.info("Address details");
        logger.info("Address ID: " + address.getId() + " Address type:  " + address.getAddressType() +
                " Owner ID" + address.getUser().getId() + " Owner name " + address.getUser().getName().getFirstName() +
                " " + address.getUser().getName().getLastName());
        return true;
    }

    public boolean checkPersistedCreditCard(CreditCard creditCard) {
        Assert.assertNotNull(creditCard);
        logger.info("Credit card details");
        logger.info("Credit card number: " + creditCard.getCreditCardNumber() + " Expiry year" + creditCard.getExpiryYear() +
                " Expiry month: " + creditCard.getExpiryMonth() + " Owner ID" + creditCard.getOwner().getId() +
                " Owner name " + creditCard.getOwner().getName().getFirstName() + " " + creditCard.getOwner().getName().getLastName());
        return true;
    }

    public boolean checkPersistedBankAccount(BankAccount bankAccount) {
        Assert.assertNotNull(bankAccount);
        logger.info("Bank account details");
        logger.info("Account number: " + bankAccount.getAccountNumber() + " Bank name: " +
                bankAccount.getBankName() + " Account ID: " + bankAccount.getId() + " Owner ID" + bankAccount.getOwner().getId() +
                " Owner name " + bankAccount.getOwner().getName().getFirstName() + " " + bankAccount.getOwner().getName().getLastName());
        return true;
    }

    public boolean checkRemovedUser(User removedUser) {
        User user = userService.getUser(removedUser.getId());
        Assert.assertNull(user);
        if (removedUser.getUserType().equals(UserType.SELLER)) {
            if (removedUser.getSellingItems() != null) {
                for (Item item : removedUser.getSellingItems()) {
                    checkRemovedItem(item);
                }
            }
        } else if (removedUser.getUserType().equals(UserType.BUYER)) {
            if (removedUser.getBids() != null) {
                for (Bid bid : removedUser.getBids()) {
                    checkRemovedBid(bid);
                }
            }
        }
        for (Address address : removedUser.getAddresses()) {
            checkRemovedAddress(address);
        }
        for (CreditCard creditCard : removedUser.getCreditCards()) {
            checkRemovedCreditCard(creditCard);
        }
        for (BankAccount bankAccount : removedUser.getBankAccounts()) {
            checkRemovedBankAccount(bankAccount);
        }

        return true;
    }

    public boolean checkRemovedItem(Item removedItem) {
        Item item = itemService.getItem(removedItem.getId());
        Assert.assertNull(item);
        for (Bid bid : removedItem.getBids()) {
            checkRemovedBid(bid);
        }
        for (Image image : removedItem.getImages()) {
            checkRemovedImage(image);
        }
        return true;
    }

    public boolean checkRemovedImage(Image removedImage) {
        Image image = imageService.getImage(removedImage.getId());
        Assert.assertNull(image);
        return true;
    }

    public boolean checkRemovedAddress(Address removedAddress) {
        Address address = addressService.getAddress(removedAddress.getId());
        Assert.assertNull(address);
        return true;
    }

    public boolean checkRemovedCreditCard(CreditCard removedCreditCard) {
        CreditCard creditCard = creditCardService.getCreditCard(removedCreditCard.getId());
        Assert.assertNull(creditCard);
        return true;
    }

    public boolean checkRemovedBankAccount(BankAccount removedBankAccount) {
        BankAccount bankAccount = bankAccountService.getBankAccount(removedBankAccount.getId());
        Assert.assertNull(bankAccount);
        return true;
    }

    public boolean checkRemovedCategory(Category removedCategory) {
        Category category = categoryService.getCategory(removedCategory.getId());
        Assert.assertNull(category);
        return true;
    }

    public boolean checkRemovedBid(Bid removedBid) {
        Bid bid = bidService.getBid(removedBid.getId());
        Assert.assertNull(bid);
        return true;
    }

    public boolean checkUpdatedItem(Item updatedItem) {
        Item item = itemService.getItem(updatedItem.getId());

        Assert.assertEquals(item.getName(), updatedItem.getName());
        Assert.assertEquals(item.getCategory(), updatedItem.getCategory());
        Assert.assertEquals(item.getDescription(), updatedItem.getDescription());
        return true;
    }
}
