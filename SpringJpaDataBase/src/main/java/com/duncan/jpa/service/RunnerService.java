package com.duncan.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duncan.jpa.entitys.Runner;
import com.duncan.jpa.repository.RunnerRepository;


// This class contains the business logic

@Service
public class RunnerService {
	
	@Autowired
	private RunnerRepository runnerRepo;
	
	public List<Runner> getRunnerByFirstName(String fName){
		List<Runner> runners = runnerRepo.findByFirstName(fName);
		return runners;
	}
	
	public void addRunner(String firstName, String lastName, String emailId) {
		Runner runner = new Runner(firstName, lastName, emailId);
		runnerRepo.save(runner);
	}
	
}
