package com.amudhan.caveatemptor.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.amudhan.caveatemptor.constant.BidQueries;
import com.amudhan.caveatemptor.dao.BidDao;
import com.amudhan.caveatemptor.entity.Bid;

@Repository
public class BidDaoImpl implements BidDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Bid> getBids() {
		Query query = entityManager.createNamedQuery(BidQueries.GETALLBIDS);
		return query.getResultList();
	}
	
	@Override
	public Bid getBid(long id) {
		return entityManager.find(Bid.class, id);
	}

	@Override
	public void persist(Bid bid) {
		entityManager.persist(bid);
	}

	@Override
	public void remove(Bid bid) {
		entityManager.remove(bid);
	}
	
}
