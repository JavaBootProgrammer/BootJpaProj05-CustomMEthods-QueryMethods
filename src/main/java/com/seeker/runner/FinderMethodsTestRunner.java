
package com.seeker.runner;

import java.util.List;

import com.seeker.entity.JobSeeker;
import com.seeker.service.IJobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerService jobSeekerService;

	@Override
	public void run(String... args) {

		List<JobSeeker> list = jobSeekerService.showAllJobSeekersService();
		list.forEach(System.out::println);


	}

}
