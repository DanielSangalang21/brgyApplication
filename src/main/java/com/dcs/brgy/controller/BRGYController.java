package com.dcs.brgy.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public abstract class BRGYController {

	/**
	For retrieving current session for setting attributes
	@return return request session
	*/
  private HttpSession getSession(HttpServletRequest request) {
	  return request.getSession();
  }
  
  /**
	@param HttpServletRequest = current request
	@param name = name of attribute
	@param attribute =  object attribute to be set to the current session using the name
	*/
  public void setSessionAttr(HttpServletRequest request,String name, Object attribute) {
	  HttpSession session = getSession(request);
	  session.setAttribute(name, attribute);
  }
  
  /**
	@param HttpServletRequest = current request
	@param name = name of attribute to be removed in the current session
	*/
  public void removeSessionAttr(HttpServletRequest request,String name) {
	  HttpSession session = getSession(request);
	  session.removeAttribute(name);
  }
  
  //convert BR objecterrors to array of field error
	public List<String>  fieldErrorsToList(BindingResult br) {	
		List<ObjectError> oe = br.getAllErrors();
		return oe.stream().map((e) -> (FieldError) e).map((fe) -> fe.getField()).collect(Collectors.toList());
	}
	
	//will create a concatenated string of error fields for js use
	public String errorsString(BindingResult br) {
		List<String> fields = fieldErrorsToList(br);
		StringBuffer sb = new StringBuffer();
		/*
		 * int counter = 0; fields.forEach((x) -> { sb.append(x);
		 * if(counter<fields.size()) { sb.append("_"); }
		 * 
		 * } );
		 */
		
		IntStream.range(0, fields.size())
		.forEach((idx) -> {
							if (fields.size() - 1 == idx) {
								sb.append(fields.get(idx));
							} else {
								sb.append(fields.get(idx) + "_");
							}
						});
		return sb.toString();
	}
 
}
