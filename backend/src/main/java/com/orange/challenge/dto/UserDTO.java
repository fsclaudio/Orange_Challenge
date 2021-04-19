package com.orange.challenge.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.orange.challenge.entyties.Address;
import com.orange.challenge.entyties.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private Instant birtdate;
	
	private List<AddressDTO> address = new ArrayList<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String cpf, Instant birtdate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birtdate = birtdate;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.birtdate = entity.getBirtDate();
	}
	
	public UserDTO(User entity, Set<Address> addresses){
		this(entity);
		addresses.forEach(adr -> this.address.add(new AddressDTO(adr)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getBirtdate() {
		return birtdate;
	}

	public void setBirtdate(Instant birtdate) {
		this.birtdate = birtdate;
	}

	public List<AddressDTO> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDTO> address) {
		this.address = address;
	}
	
	

}
