package com.amudhan.caveatemptor.test.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amudhan.caveatemptor.entity.Bid;
import com.amudhan.caveatemptor.service.BidService;
import com.amudhan.caveatemptor.test.ServiceTest;

public class BidServiceTest extends ServiceTest {
	
	@Inject
	private BidService bidService;
	private static final Logger logger = LoggerFactory.getLogger(BidServiceTest.class);
	
	@Test
	public void getBid(){
		Bid bid = bidService.getBid(10000001);
		Assert.assertNotNull(bid);
		Assert.assertEquals(bid.getId(), 10000001);
		Assert.assertEquals(bid.getAmount(), new BigDecimal(6500));
		Assert.assertEquals(bid.isSuccess(), false);
		logger.info(bid.getId()+" "+bid.getAmount());
	}
	
	@Test
	public void getBids(){
		List<Bid> bids = bidService.getBids();
		Assert.assertNotNull(bids);
		for(Bid bid : bids){
			logger.info(bid.getId()+" "+bid.getAmount());
		}
	}
}
