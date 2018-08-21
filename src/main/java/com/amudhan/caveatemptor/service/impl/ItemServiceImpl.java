package com.amudhan.caveatemptor.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.entity.Item;
import com.amudhan.caveatemptor.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Inject
	private ItemDao itemDao;
	
	@Override
	public Item getItem(long id) {
		Item item = itemDao.getItem(id); 
		return item;
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public void persist(Item item) {
		itemDao.persist(item);
	}

	@Override
	public void remove(Item item) {
		itemDao.remove(item);
	}

}
