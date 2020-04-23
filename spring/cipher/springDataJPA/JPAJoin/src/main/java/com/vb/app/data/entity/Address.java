package com.vb.app.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@Column(name="addressId")
	private Long addressId;
	
	@Column(name="city")
	private String city;
	
	public Address() {}

	public Address(Long addressId, String city) {
		super();
		this.addressId = addressId;
		this.city = city;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + "]";
	}
}