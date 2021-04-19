package com.orange.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orange.challenge.entyties.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
