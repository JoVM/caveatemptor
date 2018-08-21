package com.amudhan.caveatemptor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Mapping an entity to a subselect. 
 * This creates a summary of bids and items.
 * The Subselect loads the result of the given SQL statement into the entity.
 * **/
@Entity
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(
		value="select i.id as id, i.name as name, count(b.id) as numberofbids from item as i inner join bid as b on i.id=b.itemid"
				+ " group by i.id, i.name")
@org.hibernate.annotations.Synchronize({"Item", "Bid"})
public class ItemBidSummary {
	@Id
	private long id;
	private String name;
	private long numberOfBids;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumberOfBids() {
		return numberOfBids;
	}
	public void setNumberOfBids(long numberOfBids) {
		this.numberOfBids = numberOfBids;
	}
}
