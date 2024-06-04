
package com.seeker.runner;

import java.util.Arrays;
import java.util.List;

import com.seeker.entity.JobSeeker;
import com.seeker.repository.IJobSeekerRepository;
import com.seeker.service.IJobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IJobSeekerRepository jsRepo;

	@Override
	public void run(String... args) throws Exception {

		List<JobSeeker> list = jsRepo.showAllJobSeekers();
		list.forEach(js -> {
			System.out.println(js);
		});
		jsRepo.showAllJobSeekersByPercentageRange(45.0, 78.9).forEach(System.out::println);

		List<Object[]> list2 = jsRepo.showJobSeekerDataByQualifications("B.E", "B.sc", "B.tech");
		list2.forEach(row -> {
			for (Object val : row) {
				System.out.print(val + "  ");
			}
			System.out.println();
		});

		list2.forEach(row -> {
			System.out.println(Arrays.toString(row));
		});

		List<Long> list1 = jsRepo.showJobSeekersMobileNumbersByNameStartChars("m%");
		list1.forEach(System.out::println);

		System.out.println(" Job Seeker details ::" + jsRepo.getJobSeekerByMobileNo(88888811L));
		System.out.println("----------------------");
		System.out.println(" Job Seeker details::");
		Object details[] = (Object[]) jsRepo.getJobSeekerDataByMobileNo(88888811L);
		System.out.println(Arrays.toString(details));
		System.out.println("----------------------");
		String jsName = jsRepo.getJobSeekerNameByMobileNo(88888811L);
		System.out.println(jsName);

		System.out.println("JobSeekers count::" + jsRepo.showJobSkeersCount());

		System.out.println("------------------");
		Object[] details1 = (Object[]) jsRepo.showJobSeekerAggregateResults();
		System.out.println(" aggregate results ::" + Arrays.toString(details));
		System.out.println("count::" + details1[0] + "  max avg:" + details1[1] + " min avg:" + details1[2]
				+ " sum avg:" + details1[3] + "..." + "avg of avg::" + details1[4]);
	}

}
