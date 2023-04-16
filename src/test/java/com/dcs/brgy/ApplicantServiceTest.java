package com.dcs.brgy;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dcs.brgy.entity.Applicant;
import com.dcs.brgy.service.ApplicantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicantServiceTest{
	@Autowired
	private ApplicantService applicantService;

    @Test
    public void whenApplicationStarts_thenCheckRecords() {
        List<Applicant> applicants = applicantService.list();

        Assert.assertEquals(applicants.size(), 2);
    }
    
    @Test
    public void whenApplicationStarts_thenHibernateAddsRecords() {
    	Applicant applicant = new Applicant();
    	applicant.setMiddlename("kri");
    	applicant.setLastname("haps");
    	applicant.setFirstname("Zel");
    //	applicant.setBirthDate(new javaDate());
    	//applica
    	applicantService.addApplicant(applicant);
    	
    	List<Applicant> applicants = applicantService.list();
        Assert.assertEquals(applicants.size(), 3);
    }
}
