package com.orange.challenge.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.challenge.entyties.Address;
import com.orange.challenge.services.AddressService;

@RestController
@RequestMapping(value = "/adresses")
public class AddressResource {

	@Autowired
	private AddressService service;
	
	@GetMapping /// Chamado get
	public ResponseEntity<List<Address>> findAll(){
		List<Address> list = service.findAll();
		
		return ResponseEntity.ok().body(list); // resposta 200
	}
}