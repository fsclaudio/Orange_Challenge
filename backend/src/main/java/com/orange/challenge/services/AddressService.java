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

	@Transactional
	public AddressDTO insert(AddressDTO dto) {
		Address entity = new Address();
		entity.setPublicarea(dto.getPublicarea());
		entity.setNumber(dto.getNumber());
		entity.setComplement(dto.getComplement());
		entity.setDistrict(dto.getDistrict());
		entity.setCity(dto.getCity());
		entity.setState(dto.getState());
		entity.setZipcode(dto.getZipcode());
		entity= repository.save(entity);
		return new AddressDTO(entity);
	}

}
