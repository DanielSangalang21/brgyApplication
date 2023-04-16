package com.dcs.brgy.controller;

import java.util.List;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dcs.brgy.entity.Applicant;
import com.dcs.brgy.entity.ImageAjax;
import com.dcs.brgy.service.ApplicantService;
import com.dcs.brgy.service.CivilStatusService;
import com.dcs.brgy.util.Base64decodedMultiPartfile;
import com.dcs.brgy.util.FileHelper;
import com.dcs.brgy.util.PropertyHelper;

@Controller
@RequestMapping("/applicant")
public class ApplicantController extends BRGYController{
	
	private final static Logger log = LoggerFactory.getLogger(ApplicantController.class);
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private CivilStatusService csService;
	
	@GetMapping(value="/register")
	public String formBacking(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException{
	
		Applicant applicant = new Applicant();
		model.addAttribute("applicant",applicant);
		
		setSessionAttr(request,"barangayAdd", PropertyHelper.value("brgy.name"));
		setSessionAttr(request,"cityAdd", PropertyHelper.value("brgy.city"));
		setSessionAttr(request,"provinceAdd", PropertyHelper.value("brgy.province"));
		setSessionAttr(request,"maxImageSize", PropertyHelper.value("max.file.size.bytes"));
		setSessionAttr(request,"defProfPic", PropertyHelper.value("default.profile.photo"));
		setSessionAttr(request,"pageTitle", "Applicant Registration");
		setSessionAttr(request,"csList", csService.getAll());
		return "applicantRegistration";
	}
	
	@PostMapping(value="/register",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String register(HttpServletRequest request, HttpServletResponse response,@Valid @ModelAttribute Applicant applicant,BindingResult br,Model model,RedirectAttributes redirectAttrs) throws IOException, InterruptedException{
		
		if(br.hasErrors()) {
			model.addAttribute("errors",errorsString(br));	
			model.addAttribute("applicant", applicant);
			return "applicantRegistration";
		}
	
		//String dir = FileHelper.saveFile(request, applicant.getImageFile());
		//format to valid filedirectory
		//applicant.setImage(FileHelper.formatFilePathStr(applicant.getImage()));
		applicant.setFullImagePath(FileHelper.registerFile(applicant.getFullImagePath()));
		applicant.setImage(FileHelper.formatFilePathStr(applicant.getFullImagePath()));
		applicant.setRegistrationDate(new Date());
		
		//log.info("file directory = {}",dir);
		applicant = applicantService.addApplicant(applicant);
		redirectAttrs.addAttribute("id", applicant.getApplicantNo())
		.addFlashAttribute("successMessage", "prof.registration.success");
		return "redirect:/applicant/{id}";
	}
	
	@GetMapping(value="{id}")
	public String getApplicant(HttpServletRequest request, HttpServletResponse response, 
			Model model, @PathVariable(value="id") int id) throws IOException{
		setSessionAttr(request,"pageTitle", "Applicant Profile");
		Applicant applicant = applicantService.getOne(id);
		model.addAttribute("applicant",applicant);
		return "applicantInfo";
	}
	
	@GetMapping(value="/all")
	public String all(HttpServletRequest request, HttpServletResponse response, 
			Model model) throws IOException{
		setSessionAttr(request,"pageTitle", "Applicant List");
		String filternm = request.getParameter("name");
		List<Applicant> applicants;
		if(StringUtils.isNotBlank(filternm)) {
			applicants = applicantService.filterApplicants(filternm);
			if(applicants.size()==0) model.addAttribute("noResults",filternm);
		}else {
			applicants = applicantService.list();
		}
		model.addAttribute("applicants",applicants);
		return "applicants";
	}
	
	@PostMapping(value = "/uploadImg", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, String> uploadImage(HttpServletRequest request, @RequestBody ImageAjax imageAjax,
			HttpServletResponse response, BindingResult br, Model model) throws IOException {

		String img = imageAjax.getImage().split(",")[1];
		if (StringUtils.isEmpty(imageAjax.getFullName())) {
			imageAjax.setFullName("NO_NAME_SPECIFIED");
		}
		byte[] imageBytes = DatatypeConverter.parseBase64Binary(img);
		Base64decodedMultiPartfile mpFile = new Base64decodedMultiPartfile(imageBytes, imageAjax.getFullName());
		response.setStatus(HttpServletResponse.SC_OK);

		HashMap<String, String> map = new HashMap<>();
		//save image and return directory with to valid file directory format
		String fileNm = FileHelper.saveFile(request, mpFile);
		map.put("directory",FileHelper.formatFilePathStr( fileNm));
		map.put("fullDirectory",fileNm);
		return map;
	}
}
