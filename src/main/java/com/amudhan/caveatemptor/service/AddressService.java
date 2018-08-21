package com.amudhan.caveatemptor.service;

import java.util.List;

import com.amudhan.caveatemptor.entity.Address;

public interface AddressService {
	public Address getAddress(long id);
	public List<Address> getAddresses();
	public void persist(Address address);
	public void remove(Address address);
}
