package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.Bid;

public interface BidDao {
	public Bid getBid(long id);
	public List<Bid> getBids();
	public void persist(Bid bid);
	public void remove(Bid bid);
}
