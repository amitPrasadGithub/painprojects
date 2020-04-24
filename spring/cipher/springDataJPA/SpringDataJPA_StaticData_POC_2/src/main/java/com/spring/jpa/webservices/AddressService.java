package com.spring.jpa.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired
	private AddressRepository address_rep;

//	private List<Address> list = new ArrayList<>(Arrays.asList(
//			new Address(1L, "defence", "nagpur", "mh", "ind", "440023")
//	));
	
	public List<Address> getAllAddresss(long id) {
//		return list;
		List<Address> list = new ArrayList<>();
		address_rep.findAll().forEach(list::add);
		
		return list;
	}
	public Address getAddressById(long id) {
/*
		for(Address address:list) {
			if(id == address.getAddressId()) 
				return address;
		}
		return null;
*/	
		
		return address_rep.findById(id).get();
	}
	public void updateAddress(Address address, int id) {
/*		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getAddressId() == id) {
				list.set(i, address);
			}
		}
*/
		address_rep.save(address);
	}
	public void insertAddress(Address address) {
//		list.add(address);	
		address_rep.save(address);
	}
	public void deleteAddressById(long id) {
/*	
		for(int i=0; i<list.size(); i++) {
			if(id == list.get(i).getAddressId()) {
				list.remove(i);
			}
		}
*/	
		address_rep.deleteById(id);
	}

}
