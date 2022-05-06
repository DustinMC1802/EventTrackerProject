package com.skilldistillery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.entities.JobApplication;
import com.skilldistillery.services.JobApplicationService;

@RequestMapping("api")
@RestController
public class JobApplicationController {
	
	@Autowired
	JobApplicationService serv;
	
	@GetMapping("index")
	public List<JobApplication> index(){
		return serv.index();	
		}

}
