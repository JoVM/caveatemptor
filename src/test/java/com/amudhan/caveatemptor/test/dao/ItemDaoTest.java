package com.amudhan.caveatemptor.test.dao;

import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.dao.UserDao;
import com.amudhan.caveatemptor.entity.*;
import com.amudhan.caveatemptor.test.DaoTest;
import com.amudhan.caveatemptor.test.common.Entities;
import com.amudhan.caveatemptor.test.common.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ItemDaoTest extends DaoTest {

    @Inject
    private ItemDao itemDao;
    @Inject
    private UserDao userDao;
    @Inject
    private Entities entities;
    @Inject
    private Validator validator;
    private static final Logger logger = LoggerFactory.getLogger(ItemDaoTest.class);

    /*TC5: Create Item*/
    @Test
    public void createItem() {
        /*A User is necessary for the creation of an item*/
        logger.info("createItem starting--------------------------------------------");
        User seller = entities.getSeller();
        Item item = entities.getItem();
        Bid bid = entities.getBid();
        bid.setItem(item);
        bid.setBidder(entities.getBuyer());
        Image image = entities.getImage();
        image.setItem(item);
        item.setSeller(seller);
        Set<Image> images = new HashSet<>();
        images.add(image);
        item.setImages(images);
        Set<Bid> bids = new HashSet<>();
        item.setBids(bids);
        seller.getSellingItems().add(item);
        userDao.persist(seller);
        entityManager.flush();
        //Item persistedItem = itemDao.getItem(item.getId());
        //validator.checkPersistedItem(persistedItem);
        seller.getSellingItems().stream().forEach(this::checkPersistedItems);
    }

    private void checkPersistedItems(Item persistedItem) {
        validator.checkPersistedItem(itemDao.getItem(persistedItem.getId()));
    }

    @Test
    public void updateItem() {
        /*A User is necessary for the creation of an item*/
        logger.info("createItem starting--------------------------------------------");
        User seller = entities.getSeller();
        Item item = entities.getItem();
        Bid bid = entities.getBid();
        bid.setItem(item);
        bid.setBidder(entities.getBuyer());
        Image image = entities.getImage();
        image.setItem(item);
        item.setSeller(seller);
        Set<Image> images = new HashSet<>();
        images.add(image);
        item.setImages(images);
        Set<Bid> bids = new HashSet<>();
        item.setBids(bids);
        seller.getSellingItems().add(item);
        userDao.persist(seller);
        entityManager.flush();
        seller.getSellingItems().stream().forEach(this::checkPersistedItems);

        logger.info("updateItem starting--------------------------------------------");
        seller.getSellingItems().stream().forEach(i -> {
            Item newItem = entities.getItem();
            Category category = entities.getCategory();
            category.setItems(Collections.singleton(i));
            newItem.setCategory(category);
            Image newImage = entities.getImage();
            newImage.setItem(i);
            newItem.addImage(newImage);
            i.merge(newItem);
        });
        userDao.merge(seller);
        entityManager.flush();
        seller = userDao.getUser(seller.getId());
        seller.getSellingItems().stream().forEach(this::checkPersistedItems);
    }

    /*TC6: Create multiple items*/
    @Test
    public void createMultipleItems() {
        logger.info("createMultipleItems starting--------------------------------------------");
        User seller = entities.getSeller();
        Item itemOne = entities.getItem();
        Item itemTwo = entities.getItem();
        Bid bidOne = entities.getBid();
        bidOne.setItem(itemOne);
        bidOne.setBidder(entities.getBuyer());
        Image imageOne = entities.getImage();
        imageOne.setItem(itemOne);
        itemOne.setSeller(seller);
        Set<Image> images = new HashSet<Image>();
        images.add(imageOne);
        itemOne.setImages(images);
        Set<Bid> bidsOne = new HashSet<Bid>();
        itemOne.setBids(bidsOne);
        Bid bidTwo = entities.getBid();
        bidTwo.setItem(itemTwo);
        bidTwo.setBidder(entities.getBuyer());
        Image imageTwo = entities.getImage();
        imageTwo.setItem(itemTwo);
        itemTwo.setSeller(seller);
        Set<Image> imagesTwo = new HashSet<Image>();
        images.add(imageTwo);
        itemTwo.setImages(imagesTwo);
        Set<Bid> bidsTwo = new HashSet<Bid>();
        itemTwo.setBids(bidsTwo);
        seller.getSellingItems().add(itemOne);
        seller.getSellingItems().add(itemTwo);
        userDao.persist(seller);
        entityManager.flush();
        Item persistedItemOne = itemDao.getItem(itemOne.getId());
        Item persistedItemTwo = itemDao.getItem(itemTwo.getId());
        validator.checkPersistedItem(persistedItemOne);
        validator.checkPersistedItem(persistedItemTwo);
    }

    /*TC7: Remove Item*/
    /*Create an item, remove and validate*/
    @Test
    public void removeItem() {
        logger.info("removeItem starting--------------------------------------------");
        User seller = entities.getSeller();
        Item item = seller.getSellingItems().iterator().next();
        userDao.persist(seller);
        entityManager.flush();
        /*Since User#sellingItems has Cascade.ALL, any item that is present in the sellingItems
         * must to be cleaned explicitly before calling remove on that item. Otherwise the item will not be removed.*/
        seller.getSellingItems().remove(item);
        itemDao.remove(item);
        entityManager.flush();
        validator.checkRemovedItem(item);
    }

    /*TC8: Remove all items*/
    /*Assign more than one item to a seller. Remove them all and validate*/
    @Test
    public void removeAllItems() {
        logger.info("removeAllItems starting--------------------------------------------");
        User seller = entities.getSeller();
        Item itemOne = entities.getItem();
        Item itemTwo = entities.getItem();
        Bid bidOne = entities.getBid();
        bidOne.setItem(itemOne);
        bidOne.setBidder(entities.getBuyer());
        Image imageOne = entities.getImage();
        imageOne.setItem(itemOne);
        itemOne.setSeller(seller);
        Set<Image> images = new HashSet<Image>();
        images.add(imageOne);
        itemOne.setImages(images);
        Set<Bid> bidsOne = new HashSet<Bid>();
        itemOne.setBids(bidsOne);
        Bid bidTwo = entities.getBid();
        bidTwo.setItem(itemTwo);
        bidTwo.setBidder(entities.getBuyer());
        Image imageTwo = entities.getImage();
        imageTwo.setItem(itemTwo);
        itemTwo.setSeller(seller);
        Set<Image> imagesTwo = new HashSet<Image>();
        images.add(imageTwo);
        itemTwo.setImages(imagesTwo);
        Set<Bid> bidsTwo = new HashSet<Bid>();
        itemTwo.setBids(bidsTwo);
        seller.getSellingItems().add(itemOne);
        seller.getSellingItems().add(itemTwo);
        userDao.persist(seller);
        entityManager.flush();
        seller.getSellingItems().clear();
        itemDao.remove(itemOne);
        itemDao.remove(itemTwo);
        entityManager.flush();
        validator.checkRemovedItem(itemOne);
        validator.checkRemovedItem(itemTwo);
    }

    /*TC9: Remove a particular item*/
    @Test
    public void removeParticularItem() {
        logger.info("removeParticularItem starting--------------------------------------------");
        User seller = entities.getSeller();
        Item itemOne = entities.getItem();
        Item itemTwo = entities.getItem();
        Bid bidOne = entities.getBid();
        bidOne.setItem(itemOne);
        bidOne.setBidder(entities.getBuyer());
        Image imageOne = entities.getImage();
        imageOne.setItem(itemOne);
        itemOne.setSeller(seller);
        Set<Image> images = new HashSet<Image>();
        images.add(imageOne);
        itemOne.setImages(images);
        Set<Bid> bidsOne = new HashSet<Bid>();
        itemOne.setBids(bidsOne);
        Bid bidTwo = entities.getBid();
        bidTwo.setItem(itemTwo);
        bidTwo.setBidder(entities.getBuyer());
        Image imageTwo = entities.getImage();
        imageTwo.setItem(itemTwo);
        itemTwo.setSeller(seller);
        Set<Image> imagesTwo = new HashSet<Image>();
        images.add(imageTwo);
        itemTwo.setImages(imagesTwo);
        Set<Bid> bidsTwo = new HashSet<Bid>();
        itemTwo.setBids(bidsTwo);
        seller.getSellingItems().add(itemOne);
        seller.getSellingItems().add(itemTwo);
        userDao.persist(seller);
        entityManager.flush();
        seller.getSellingItems().remove(itemOne);
        itemDao.remove(itemOne);
        entityManager.flush();
        validator.checkRemovedItem(itemOne);
        validator.checkPersistedItem(itemTwo);
    }

}
