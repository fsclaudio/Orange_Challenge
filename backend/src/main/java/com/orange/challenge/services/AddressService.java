package com.orange.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orange.challenge.dto.AddressDTO;
import com.orange.challenge.entyties.Address;
import com.orange.challenge.repositories.AddressRepository;
import com.orange.challenge.services.exceptions.EntityNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Transactional(readOnly = true)
	public List<AddressDTO> findAll(){
		List<Address> list= repository.findAll();
		return list.stream().map(x -> new AddressDTO(x)).collect(Collectors.toList());	
	}
	
	@Transactional(readOnly = true) 
	public AddressDTO findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		Address entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new AddressDTO(entity);
	}

}
