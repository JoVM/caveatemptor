package com.amudhan.caveatemptor.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amudhan.caveatemptor.dao.BidDao;
import com.amudhan.caveatemptor.entity.Bid;
import com.amudhan.caveatemptor.service.BidService;

import javax.inject.Inject;

@Service
@Transactional
public class BidServiceImpl implements BidService {

	@Inject
	private BidDao bidDao;
	
	@Override
	public Bid getBid(long id) {
		return bidDao.getBid(id);
	}

	@Override
	public List<Bid> getBids() {
		return bidDao.getBids();
	}

	@Override
	public void persist(Bid bid) {
		bidDao.persist(bid);
	}

	@Override
	public void remove(Bid bid) {
		bidDao.remove(bid);
	}

}
