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
import com.orange.challenge.repositories.UserRepository;
import com.orange.challenge.services.exceptions.DataBaseException;
import com.orange.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list= repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());	
	}
	
	@Transactional(readOnly = true) 
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity, entity.getAddresses());
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
	    copyDtoToEntity(dto, entity);
	    entity = repository.save(entity);
		return new UserDTO(entity,entity.getAddresses()); 
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
		User entity = repository.getOne(id);
	    copyDtoToEntity(dto, entity); 
		entity= repository.save(entity);
		return  new UserDTO(entity);
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
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		    entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setCpf(dto.getCpf());
			entity.setBirtDate(dto.getBirtdate());
			
			entity.getAddresses().clear();
			for (AddressDTO addDTO: dto.getAddress()) {
				Address address = addressRepository.getOne(addDTO.getId());
				entity.getAddresses().add(address);
			}
	}

}
