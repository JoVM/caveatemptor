package com.amudhan.caveatemptor.dao;

import java.util.List;

import com.amudhan.caveatemptor.entity.Address;

public interface AddressDao {
	public Address getAddress(long id);
	public List<Address> getAddresses();
	public void persist(Address address);
	public void remove(Address address);
}
