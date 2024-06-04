
package com.seeker.runner;

import java.util.Arrays;
import java.util.List;

import com.seeker.entity.JobSeeker;
import com.seeker.repository.IJobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerRepository jobSeekerRepository;

	@Override
	public void run(String... args) throws Exception {

		List<JobSeeker> list = jobSeekerRepository.showAllJobSeekers();
		list.forEach(js -> {
			System.out.println(js);
		});
		jobSeekerRepository.showAllJobSeekersByPercentageRange(45.0, 78.9).forEach(System.out::println);

		List<Object[]> showJobSeekerDataByQualifications = jobSeekerRepository.showJobSeekerDataByQualifications("B.E", "B.sc", "B.tech");
		showJobSeekerDataByQualifications.forEach(row -> {
			for (Object val : row) {
				System.out.print(val + "  ");
			}
			System.out.println();
		});

		showJobSeekerDataByQualifications.forEach(row -> {
			System.out.println(Arrays.toString(row));
		});

		List<Long> showJobSeekersMobileNumbersByNameStartChars = jobSeekerRepository.showJobSeekersMobileNumbersByNameStartChars("m%");
		showJobSeekersMobileNumbersByNameStartChars.forEach(System.out::println);

		System.out.println(" Job Seeker jobSeekerDataByMobileNo ::" + jobSeekerRepository.getJobSeekerByMobileNo(88888811L));
		System.out.println("----------------------");
		System.out.println(" Job Seeker jobSeekerDataByMobileNo::");
		Object jobSeekerDataByMobileNo[] = (Object[]) jobSeekerRepository.getJobSeekerDataByMobileNo(88888811L);
		System.out.println(Arrays.toString(jobSeekerDataByMobileNo));
		System.out.println("----------------------");
		String jsName = jobSeekerRepository.getJobSeekerNameByMobileNo(88888811L);
		System.out.println(jsName);

		System.out.println("JobSeekers count::" + jobSeekerRepository.showJobSkeersCount());

		System.out.println("------------------");
		Object[] showJobSeekerAggregateResults = (Object[]) jobSeekerRepository.showJobSeekerAggregateResults();
		System.out.println(" aggregate results ::" + Arrays.toString(showJobSeekerAggregateResults));
		System.out.println("count::" + showJobSeekerAggregateResults[0] + "  max avg:" + showJobSeekerAggregateResults[1] + " min avg:" + showJobSeekerAggregateResults[2]
				+ " sum avg:" + showJobSeekerAggregateResults[3] + "..." + "avg of avg::" + showJobSeekerAggregateResults[4]);
	}

}
