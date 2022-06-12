package com.codingdojo.mutualade.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mutualade.models.User;

public interface UserRepo extends CrudRepository <User, Long> {
	
	List<User> findAll();
	Optional<User> findByEmail(String email);

}
