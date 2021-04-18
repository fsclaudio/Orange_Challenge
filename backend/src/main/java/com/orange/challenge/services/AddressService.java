package com.orange.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orange.challenge.entyties.Address;
import com.orange.challenge.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Transactional(readOnly = true)
	public List<Address> findAll(){
		return repository.findAll();
		
	}

}
