package com.orange.challenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orange.challenge.dto.AddressDTO;
import com.orange.challenge.services.AddressService;

@RestController
@RequestMapping(value = "/adresses")
public class AddressResource {

	@Autowired
	private AddressService service;
	
	@GetMapping /// Chamado get
	public ResponseEntity<List<AddressDTO>> findAll(){
		List<AddressDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list); // resposta 200
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> findById(@PathVariable Long id){
		AddressDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto); // resposta 200
	}
	
	@PostMapping
	public ResponseEntity<AddressDTO> insert(@RequestBody AddressDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto); //resposta 201
	}
}
