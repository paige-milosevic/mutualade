package com.codingdojo.mutualade.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mutualade.models.OrgAid;

@Repository
public interface OrgAidRepo extends CrudRepository <OrgAid, Long> {
	
	List<OrgAid> findAll();

}
