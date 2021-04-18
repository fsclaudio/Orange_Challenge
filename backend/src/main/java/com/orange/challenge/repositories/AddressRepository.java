package com.orange.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.challenge.entyties.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
