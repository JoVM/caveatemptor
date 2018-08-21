package com.amudhan.caveatemptor.dao;

import com.amudhan.caveatemptor.entity.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> getItems();

    public Item getItem(long id);

    public void persist(Item item);

    public void remove(Item item);
}
