package com.codingdojo.mutualade.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mutualade.models.AidRequest;

@Repository
public interface AidRepo extends CrudRepository <AidRequest, Long> {

	List<AidRequest> findAll();
	
	
}
