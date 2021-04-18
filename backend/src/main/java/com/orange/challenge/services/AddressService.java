package com.orange.challenge.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orange.challenge.dto.AddressDTO;
import com.orange.challenge.entyties.Address;
import com.orange.challenge.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Transactional(readOnly = true)
	public List<AddressDTO> findAll(){
		List<Address> list= repository.findAll();
		return list.stream().map(x -> new AddressDTO(x)).collect(Collectors.toList());
		
	}

}
