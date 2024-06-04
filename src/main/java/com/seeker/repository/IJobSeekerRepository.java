package com.seeker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seeker.entity.JobSeeker;
import org.springframework.data.jpa.repository.Query;

public interface IJobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	// Entity name
	// @Query("from JobSeeker")

	// Entity name with the package name
	// @Query("from com.seeker.entity.JobSeeker")

	// Entity name with alias
	// @Query("from JobSeeker as JS")

	// @Query("from JobSeeker")
	// public List<JobSeeker> showAllJobSeekers();

	// @Query("from JobSeeker")
	// @Query("from com.nt.entity.JobSeeker")
	// @Query("from com.nt.entity.JobSeeker as js")
	// @Query("from com.nt.entity.JobSeeker js")
	@Query("select js from com.seeker.entity.JobSeeker js")
	public List<JobSeeker> showAllJobSeekers();

	/*
	 * @Query(" from JobSeeker where  percentage>=:min and percentage<=:max") public
	 * List<JobSeeker> showAllJobSeekersByPercentageRange(@Param("min") double
	 * start,@Param("max") double end);
	 */

//	
//	  @Query(" from JobSeeker where  percentage>=:start and percentage<=:end")
//	  public List<JobSeeker> showAllJobSeekersByPercentageRange( double start, double end);
//	  

	@Query(" from JobSeeker where  percentage>=:start and percentage<=:end")
	public List<JobSeeker> showAllJobSeekersByPercentageRange(double start, double end);

	@Query("select jobSeekerID, jobSeekerName,qlfy from JobSeeker where  qlfy in(:qlfy1,:qlfy2,:qlfy3) order by qlfy  desc")
	public List<Object[]> showJobSeekerDataByQualifications(String qlfy1, String qlfy2, String qlfy3);

	@Query(" select mobileNo from JobSeeker where jobSeekerName like :initChars ")
	public List<Long> showJobSeekersMobileNumbersByNameStartChars(String initChars);

	// ========================= Seelect single record ===================
	@Query("from  JobSeeker where  mobileNo=:no")
	public JobSeeker getJobSeekerByMobileNo(long no);

	@Query("select  jobSeekerID,jobSeekerName,qlfy from  JobSeeker where  mobileNo=:no")
	public Object getJobSeekerDataByMobileNo(long no);

	@Query("select  jobSeekerName from  JobSeeker where  mobileNo=:no")
	public String getJobSeekerNameByMobileNo(long no);

	// ===============Aggregate operations====================
	@Query("select count(*)  from JobSeeker")
	public long showJobSkeersCount();

	@Query("select count(*),max(percentage),min(percentage),avg(percentage),sum(percentage)  from JobSeeker")
	public Object showJobSeekerAggregateResults();

}
