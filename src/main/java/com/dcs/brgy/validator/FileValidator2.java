package com.dcs.brgy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import com.dcs.brgy.util.MessageResolver;
import com.dcs.brgy.validator.annotation.FileConstraint;

public class FileValidator2 implements ConstraintValidator<FileConstraint, MultipartFile> {

	@Override
	public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		context.disableDefaultConstraintViolation();
		
		if(file == null || file.isEmpty() || file.getSize()<=0) {
			context.buildConstraintViolationWithTemplate("{missing.image}").addConstraintViolation();
			return false;
		}   
		
		String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1,
				  file.getOriginalFilename().length()).toLowerCase();
		
		if(!fileType.equals("img") && !fileType.equals("jpg") && !fileType.equals("jpeg") && !fileType.equals("png")) { 
			context.buildConstraintViolationWithTemplate(MessageResolver.resolve("unsupported.file", new Object[]{"image"})).addConstraintViolation();
			return false;
		}
		
		if(file.getSize() > 10485760) {	
			context.buildConstraintViolationWithTemplate("{max.file.size}").addConstraintViolation();
			return false;
		}
		
		return true;
	}

}
