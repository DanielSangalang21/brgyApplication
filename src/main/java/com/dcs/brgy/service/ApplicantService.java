package com.dcs.brgy.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.dcs.brgy.entity.Applicant;
import com.dcs.brgy.repository.ApplicantRepository;
import com.dcs.brgy.util.FileHelper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class ApplicantService {

	private final String REPORT_PATH = "D:\\brgyApp\\reports\\";
	@Autowired
	private ApplicantRepository applicantRepository;

	public List<Applicant> list() {
		return applicantRepository.findAll();
	}

	public Applicant addApplicant(Applicant applicant) {
		return applicantRepository.save(applicant);
	}

	public Applicant getOne(int id) {
		return applicantRepository.getReferenceById(id);
	}

	public String generateBarangayClearance(Applicant applicant) throws FileNotFoundException, JRException {

		File file = ResourceUtils.getFile("classpath:reports/BarangayClearance.jrxml");
		List<Applicant> applicants = Arrays.asList(applicant);
		JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("APPLICANT_IMAGE", FileHelper.imagePathForReport(applicant.getImage()));
		parameters.put("BARANGAY", "TALAGA");
		parameters.put("LOGO", "src/main/resources/images/mabini.jpg");
		parameters.put("OR_NO", "TALAGA");
		parameters.put("BACKGROUND_IMAGE", "src/main/resources/images/mabini.jpg");
		parameters.put("BARANGAY_CAPTAIN", "Daniel Talaga");
		parameters.put("DATE_ISSUED", new Date());

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(applicants);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
		String filePath = REPORT_PATH + applicant.getFirstname() + applicant.getLastname() + ".pdf"; // will use
																										// FileHelper.fileNameGenerator()
		JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);

		return filePath;
	}
	
	public List<Applicant> filterApplicants(String name){
		return applicantRepository.filterApplicants(name);
	}
	
}
