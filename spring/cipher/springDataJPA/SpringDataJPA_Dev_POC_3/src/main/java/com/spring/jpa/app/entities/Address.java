package com.spring.jpa.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Address {
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;
	
	@Column(name="area", length=60)
	private String area;
	
	@Column(name="city", length=60)
	private String city;
	
	@Column(name="state", length=60)
	private String state;
	
	@Column(name="country", length=60)
	private String country;

	
	public Address() {}
	
	public Address(String area, String city, String state, String country) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}
}
