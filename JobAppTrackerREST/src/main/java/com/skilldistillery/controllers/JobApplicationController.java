package com.skilldistillery.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.entities.JobApplication;
import com.skilldistillery.services.JobApplicationService;

@RequestMapping("api")
@RestController
public class JobApplicationController {
	
	@Autowired
	JobApplicationService serv;
	
	@GetMapping("apps")
	public List<JobApplication> index(){
		return serv.index();	
		}
	
	@PostMapping("apps")
	public JobApplication create(
			@RequestBody JobApplication app,
			HttpServletResponse res
			) {
		JobApplication newApp = serv.create(app);
		if(newApp != null) {
			res.setStatus(201);
		}
		return newApp;
	}
	
	
	@GetMapping("apps/{appId}")
	public JobApplication retrieve(
			@PathVariable Integer appId,
			HttpServletResponse res
			){
		JobApplication jobApp = serv.retrieve(appId);
		if(jobApp == null) {
			res.setStatus(404);
		}
		return jobApp;
	}
	
	@PutMapping("apps/{appId}")
	public JobApplication update(
			@RequestBody JobApplication app,
			@PathVariable("appId") Integer appId,
			HttpServletResponse res
			) {
		try {
			app = serv.update(app, appId);
			if (app == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			app = null;
		}
		return app;
	}
	
	@DeleteMapping("apps/{appId}")
	public void delete(@PathVariable Integer appId) {
		serv.delete(appId);
	}
}
