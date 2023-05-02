package com.codingdojo.mutualade.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mutualade.models.Member;

@Repository
public interface MemberRepo extends CrudRepository <Member, Long>{

	List<Member> findAll();

}
