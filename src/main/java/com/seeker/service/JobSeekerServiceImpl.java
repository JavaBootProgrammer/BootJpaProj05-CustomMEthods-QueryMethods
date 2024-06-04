package com.seeker.service;

import com.seeker.entity.JobSeeker;
import com.seeker.repository.IJobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JobSeekerServiceImpl implements IJobSeekerService {

	@Autowired
	private IJobSeekerRepository jobSeekerRepository;

	@Override
	public List<JobSeeker> showAllJobSeekersService() {
		return jobSeekerRepository.showAllJobSeekers();
	}

}
