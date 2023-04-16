package com.dcs.brgy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dcs.brgy.entity.Applicant;
import com.dcs.brgy.service.ApplicantService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/brgyClearance")
public class BrgyClearanceController  extends BRGYController{

	@Autowired
	ApplicantService applicantService;
	
	@GetMapping(value="/request")
	public String form(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttrs) throws IOException, JRException{
		//Applicant unproxApplicant = (Applicant) Hibernate.unproxy(applicant);
		model.addAttribute(new Applicant());
		String fromProfile = request.getParameter("fromProfile");
		if(StringUtils.isNotBlank(fromProfile)){
			int id = Integer.valueOf(request.getParameter("applicantNo"));
			redirectAttrs.addAttribute("id", id);
			return "redirect:/brgyClearance/request/{id}";
		}
		setSessionAttr(request,"pageTitle", "Request Barangay Clearance");
		return "brgyClearance";
	}
	
	@PostMapping(value="/request", produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String generateBarangayClearance(HttpServletRequest request,@ModelAttribute Applicant applicant) throws IOException, JRException{
		Applicant app = applicantService.getOne(applicant.getApplicantNo());
		//Applicant unproxApplicant = (Applicant) Hibernate.unproxy(applicant);
		
		Applicant unproxedApp = (Applicant) Hibernate.unproxy(app); 
		unproxedApp.setFullName();
		System.out.println(app.getFullName());
		String dir = applicantService.generateBarangayClearance(unproxedApp);
		return "File saved to: " + dir;
	}
	
	@PostMapping(value="/request/{id}", produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String generateBarangayClearanceById(HttpServletRequest request,@PathVariable int id) throws IOException, JRException{
		Applicant app = applicantService.getOne(id);
		//Applicant unproxApplicant = (Applicant) Hibernate.unproxy(applicant);
		
		Applicant unproxedApp = (Applicant) Hibernate.unproxy(app); 
		unproxedApp.setFullName();
		System.out.println(app.getFullName());
		String dir = applicantService.generateBarangayClearance(unproxedApp);
		return "File saved to: " + dir;
	}
}
