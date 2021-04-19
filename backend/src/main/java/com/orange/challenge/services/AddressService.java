package com.orange.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orange.challenge.dto.AddressDTO;
import com.orange.challenge.dto.UserDTO;
import com.orange.challenge.entyties.Address;
import com.orange.challenge.entyties.User;
import com.orange.challenge.repositories.AddressRepository;
import com.orange.challenge.services.exceptions.DataBaseException;
import com.orange.challenge.services.exceptions.ResourceNotFoundException;

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
		Address entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO insert(AddressDTO dto) {
		Address entity = new Address();
		copyDtoToEntity(dto, entity);
		entity= repository.save(entity);
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO update(Long id, AddressDTO dto) {
		try {
		Address entity = repository.getOne(id);
		copyDtoToEntity(dto, entity);
		entity= repository.save(entity);
		return  new AddressDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found! " +id); 
		}
		
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found! " +id);
		}
		
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
	}
	
	private void copyDtoToEntity(AddressDTO dto, Address entity) {
		entity.setPublicarea(dto.getPublicarea());
		entity.setNumber(dto.getNumber());
		entity.setComplement(dto.getComplement());
		entity.setDistrict(dto.getDistrict());
		entity.setCity(dto.getCity());
		entity.setState(dto.getState());
		entity.setZipcode(dto.getZipcode());
	}

}
