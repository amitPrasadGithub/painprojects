package com.spring.jpa.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	@Autowired
	private AddressService address_service;
	
	@RequestMapping("/address/{id}/addresses")
	public List<Address> getAllAddresss(@PathVariable String id) {
		return address_service.getAllAddresss(Long.parseLong(id));
	}
	
	@RequestMapping("students/{studentId}/address/{addressId}")
	public Address getAddressById(@PathVariable String addressId) {
		return address_service.getAddressById(Integer.parseInt(addressId));
	}
	@RequestMapping(method=RequestMethod.PUT, value="students/{studentId}/address/{addressId}")
	public void updateAddress(@RequestBody Address address, @PathVariable String addressId) {
		address.setStudent(new Student(Long.parseLong(addressId), "", ""));
		address_service.updateAddress(address, Integer.parseInt(addressId));
	}
	@RequestMapping(method=RequestMethod.POST, value="students/{studentId}/address")
	public void insertAddress(@RequestBody Address address, @PathVariable String studentId) {
		address.setStudent(new Student(Long.parseLong(studentId), "", ""));
		address_service.insertAddress(address);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="students/{studentId}/address/{addressId}")
	public void deleteAddressById(@PathVariable String addressId) {
		address_service.deleteAddressById(Long.parseLong(addressId));
	}

}
