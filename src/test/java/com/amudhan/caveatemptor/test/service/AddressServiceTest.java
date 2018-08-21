package com.amudhan.caveatemptor.test.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.amudhan.caveatemptor.entity.Address;
import com.amudhan.caveatemptor.service.AddressService;
import com.amudhan.caveatemptor.test.ServiceTest;

public class AddressServiceTest extends ServiceTest {
	
	@Inject
	private AddressService addressService;
	private static final Logger logger = LoggerFactory.getLogger(AddressServiceTest.class);
	
	public void getAddress(){
		Address address = addressService.getAddress(10000005);
		Assert.assertNotNull(address);
		Assert.assertEquals(address.getId(), 10000005);
		logger.info("Address ID: "+address.getId()+" Address type: "+address.getAddressType()+
					" Full address: "+address.getBuilding()+", "+address.getStreet()+", "+address.getCity()+", "+address.getZipCode()+
					" Addressee ID: "+address.getUser().getId());	
	}
	
	public void getAddresses(){
		List<Address> addresses = addressService.getAddresses();
		Assert.assertNotNull(addresses);
		for(Address address : addresses){
			logger.info("Address ID: "+address.getId()+" Address type: "+address.getAddressType()+
					" Full address: "+address.getBuilding()+", "+address.getStreet()+", "+address.getCity()+", "+address.getZipCode()+
					" Addressee ID: "+address.getUser().getId());	
		}
	}

}
