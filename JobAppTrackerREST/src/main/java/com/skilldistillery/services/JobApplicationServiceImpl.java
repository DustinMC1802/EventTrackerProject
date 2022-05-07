package com.skilldistillery.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public JobApplication create(JobApplication jobApp) {
		return repo.saveAndFlush(jobApp);
	}

	@Override
	public JobApplication retrieve(Integer appId) {
		Optional<JobApplication> op = repo.findById(appId);
		JobApplication app = null;
		if(op.isPresent()) {
			app = op.get();
		}
		return app;
	}

	@Override
	public JobApplication update(JobApplication jobApp, Integer appId) {
		jobApp.setId(appId);
		if(repo.existsById(appId)) {
			return repo.save(jobApp);
		} else {
			return null;
		}
	}

	@Override
	public JobApplication delete(Integer appId) {
		if(repo.existsById(appId)) {
			repo.deleteById(appId);
		}
		return null;
	}

	
	

}
