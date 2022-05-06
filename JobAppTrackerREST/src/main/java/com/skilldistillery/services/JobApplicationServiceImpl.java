package com.skilldistillery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.entities.JobApplication;
import com.skilldistillery.repositories.JobApplicationRepository;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	
	@Autowired
	JobApplicationRepository repo;
	
	@Override
	public List<JobApplication> index() {
		return repo.findAll();
	}

}
