package com.duncan.jpa.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duncan.jpa.entitys.Runner;


@Repository
public interface RunnerRepository extends JpaRepository<Runner, Long>{

	  List<Runner> findByLastName(String lastName);
	  List<Runner> findByFirstName(String firstName);
	
}