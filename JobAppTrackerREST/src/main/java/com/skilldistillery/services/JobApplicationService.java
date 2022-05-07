package com.skilldistillery.services;

import java.util.List;

import com.skilldistillery.entities.JobApplication;

public interface JobApplicationService {
	public List<JobApplication> index();
	
	public JobApplication create(JobApplication jobApp);
	
	public JobApplication retrieve(Integer appId);
	
	public JobApplication update(JobApplication jobApp, Integer appId);
	
	public JobApplication delete(Integer appId);
	

}
