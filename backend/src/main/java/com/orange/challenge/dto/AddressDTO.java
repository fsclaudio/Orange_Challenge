package com.orange.challenge.dto;

import java.io.Serializable;

import com.orange.challenge.entyties.Address;

public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String publicarea;
	private int number;
	private String complement;
	private String district;
	private String city;
	private String state;
	private String zipcode;
	
	public AddressDTO() {
	}

	public AddressDTO(Long id, String publicarea, int number, String complement, String district, String city,
			String state, String zipcode) {
		this.id = id;
		this.publicarea = publicarea;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
     public AddressDTO(Address entity) {
    	this.id = entity.getId();
 		this.publicarea = entity.getPublicarea();
 		this.number = entity.getNumber();
 		this.complement = entity.getComplement();
 		this.district = entity.getDistrict();
 		this.city = entity.getCity();
 		this.state = entity.getState();
 		this.zipcode = entity.getZipcode();	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicarea() {
		return publicarea;
	}

	public void setPublicarea(String publicarea) {
		this.publicarea = publicarea;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

	
	
}
