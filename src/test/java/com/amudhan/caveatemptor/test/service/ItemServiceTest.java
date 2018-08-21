package com.amudhan.caveatemptor.test.service;

import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.service.ItemService;
import com.amudhan.caveatemptor.test.ServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;


public class ItemServiceTest extends ServiceTest {

    @Inject
    private ItemService itemService;
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceTest.class);

    @Test
    public void getItems() {
        List<Item> items = itemService.getItems();
        Assert.assertNotNull(items);
        for (Item item : items) {
            logger.info(item.getId() + " " + item.getName());
        }
    }

    @Test
    public void getItem() {
        Item item = itemService.getItem(10000001);
        Assert.assertNotNull(item);
        Assert.assertEquals(item.getId(), 10000001);
        Assert.assertEquals(item.getDescription(), "An awesome reader");
        Assert.assertEquals(item.getName(), "Kindle e book reader");
        Assert.assertEquals(item.getInitialPrice(), new BigDecimal(6000));
        logger.info(item.getName() + " " + item.getInitialPrice());
    }
}
