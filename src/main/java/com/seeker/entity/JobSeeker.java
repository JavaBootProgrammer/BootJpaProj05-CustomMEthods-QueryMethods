//Entity class
package com.seeker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JOB_SEEKER_INFO")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeeker {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "jsId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JS_ID")
	private Integer jobSeekerID;

	@Column(name = "JS_NAME", length = 20)
	@NonNull
	private String jobSeekerName;

	@Column(name = "JS_QLFY", length = 20)
	@NonNull
	private String qlfy;

	@Column(name = "JS_PERCENTAGE")
	@NonNull
	private Double percentage;

	// @Transient
	@Column(name = "JS_CONTACT_INFO")
	@NonNull
	private String mobileNo;

	@Override
	public String toString() {
		return "JobSeeker{" +
				"jobSeekerID=" + jobSeekerID +
				", jobSeekerName='" + jobSeekerName + '\'' +
				", qlfy='" + qlfy + '\'' +
				", percentage=" + percentage +
				", mobileNo='" + mobileNo + '\'' +
				'}';
	}

	public JobSeeker() {
		System.out.println(
				"JobSeeker:: 0-param constructor::" + this.getClass() + "....." + this.getClass().getSuperclass());
	}

}
