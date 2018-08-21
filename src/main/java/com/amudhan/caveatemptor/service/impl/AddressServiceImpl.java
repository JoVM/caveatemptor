package com.amudhan.caveatemptor.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.amudhan.caveatemptor.constant.AddressQueries;
import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Address getAddress(long id) {
		return entityManager.find(Address.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAddresses() {
		Query query = entityManager.createNamedQuery(AddressQueries.GETALLADDRESSES);
		return query.getResultList();
	}

	@Override
	public void persist(Address address) {
		entityManager.persist(address);
	}

	@Override
	public void remove(Address address) {
		entityManager.remove(address);
	}

}
