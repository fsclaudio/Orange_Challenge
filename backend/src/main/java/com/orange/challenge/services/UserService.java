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

import com.orange.challenge.dto.UserDTO;
import com.orange.challenge.entyties.User;
import com.orange.challenge.repositories.UserRepository;
import com.orange.challenge.services.exceptions.DataBaseException;
import com.orange.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
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
	//	entity.setPublicarea(dto.getPublicarea());
	//	entity.setNumber(dto.getNumber());
	//	entity.setComplement(dto.getComplement());
	//	entity.setDistrict(dto.getDistrict());
	//	entity.setCity(dto.getCity());
	//	entity.setState(dto.getState());
	//	entity.setZipcode(dto.getZipcode());
	//	entity= repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
		User entity = repository.getOne(id);
		//entity.setPublicarea(dto.getPublicarea());
	//	entity.setNumber(dto.getNumber());
	//	entity.setComplement(dto.getComplement());
//		entity.setDistrict(dto.getDistrict());
//		entity.setCity(dto.getCity());
	//	entity.setState(dto.getState());
	//	entity.setZipcode(dto.getZipcode());
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

}
