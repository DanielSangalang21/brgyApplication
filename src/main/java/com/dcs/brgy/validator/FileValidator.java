package com.dcs.brgy.validator;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.brgy.entity.Applicant;

public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Model.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Applicant applicant = (Applicant) target;

		MultipartFile file = applicant.getImageFile();

		if(file == null || file.isEmpty() || file.getSize()<=0) {
			errors.rejectValue("imageFile", "missing.image");
			return;
		}   
		
		String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1,
				  file.getOriginalFilename().length()).toLowerCase();
		
		if(!fileType.equals("img") && !fileType.equals("jpg") && !fileType.equals("jpeg") && !fileType.equals("png")) { 
			errors.rejectValue("imageFile", "unsupported.file", new Object[] {"image"}, null);
			return;
		}
		
		if(file.getSize() > 10485760) {
			errors.rejectValue("imageFile", "max.file.size");
			return;
		}
	}
}
