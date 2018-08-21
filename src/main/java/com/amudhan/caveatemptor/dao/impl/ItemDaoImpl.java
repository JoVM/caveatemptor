package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.ItemQueries;
import com.amudhan.caveatemptor.dao.ItemDao;
import com.amudhan.caveatemptor.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItems() {
		Query query = entityManager.createNamedQuery(ItemQueries.GETALLITEMS);
		return query.getResultList();
	}

	@Override
	public Item getItem(long id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	public void persist(Item item) {
		entityManager.persist(item);
	}

	@Override
	public void remove(Item item) {
		entityManager.remove(item); 
	}
}
