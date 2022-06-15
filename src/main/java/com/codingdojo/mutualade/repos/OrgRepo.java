package com.codingdojo.mutualade.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mutualade.models.Organization;

@Repository
public interface OrgRepo extends CrudRepository <Organization, Long>{

	List<Organization> findAll();
	Optional<Organization> findByOrgName(String orgName);
	
	
}
