package com.skilldistillery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.entities.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

}
