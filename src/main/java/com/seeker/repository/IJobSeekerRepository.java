package com.seeker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seeker.entity.JobSeeker;
import org.springframework.data.jpa.repository.Query;


public interface IJobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	@Query("from JobSeeker")
	public List<JobSeeker> showAllJobSeekers();



}
