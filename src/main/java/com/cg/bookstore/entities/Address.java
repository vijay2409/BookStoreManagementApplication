package com.cg.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "addresstable")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "city", nullable = false)
	@NonNull
	private String city;

	@Column(name = "country", nullable = false)
	@NonNull
	private String country;

	@Column(name = "pincode", nullable = false)
	@NonNull 
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$",message = "length must be 6")
	private String pincode;
	
	@OneToOne(mappedBy = "address")
	private Customer customer;
	
	@OneToOne(mappedBy = "shippingAddress")
	private BookOrder bookOrder;

	public Address() {
		super();
	}

	public Address(int addressId, String address, String city, String country, String pincode) {
		super();
		this.addressId=addressId;
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}