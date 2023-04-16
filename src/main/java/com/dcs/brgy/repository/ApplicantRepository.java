package com.dcs.brgy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dcs.brgy.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
	@Query(value = "Select * from ApplicantsInformation where firstname like '%'+:name+'%'",nativeQuery = true)
	public List<Applicant> filterApplicants(@Param("name") String name);
}
