package com.dcs.brgy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.hibernate.internal.util.StringHelper;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.brgy.validator.annotation.NameConstraint;

@Table(name = "ApplicantsInformation")
@Entity
public class Applicant extends BrgyBean{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicantNo;
	
	@NotBlank(message = "{mandatory}")
	@NameConstraint
	private String firstname;
	
	@NameConstraint
	private String middlename;
	
	@NotBlank(message = "{mandatory}")
	@NameConstraint
	private String lastname;
	
	@NotBlank(message = "{mandatory}")
	private String sex;
	
	private String suffix;
	
	private java.sql.Date birthDate;
	
	private int age;
	
	@NameConstraint
	@NotBlank(message = "{mandatory}")
	private String nationality;
	
	@NotBlank(message = "{mandatory}")
	private String civilStatus;
	
	@NotBlank(message = "{mandatory}")
	private String addHouseNo;
	
	@NotBlank(message = "{mandatory}")
	private String addStreet;

	@NameConstraint
	@NotBlank(message = "{mandatory}")
	private String religion;
	
	private String addBarangay;
	private String addCity;
	private String addProvince;
	
	private Date registrationDate;
	//for showing and retrieval
	private String image;
	
	//for filepath editing
	private String fullImagePath;
	@Transient //not persistent property
	//@FileConstraint
	private MultipartFile imageFile;

	@Transient
	private String fullName;
	
	@Transient
	private String errorsConcat;
	
	
	public int getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(int applicantNo) {
		this.applicantNo = applicantNo;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getAddHouseNo() {
		return addHouseNo;
	}

	public void setAddHouseNo(String addHouseNo) {
		this.addHouseNo = addHouseNo;
	}

	public String getAddStreet() {
		return addStreet;
	}

	public void setAddStreet(String addStreet) {
		this.addStreet = addStreet;
	}

	public String getAddBarangay() {
		return addBarangay;
	}

	public void setAddBarangay(String addBarangay) {
		this.addBarangay = addBarangay;
	}

	public String getAddCity() {
		return addCity;
	}

	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}

	public String getAddProvince() {
		return addProvince;
	}

	public void setAddProvince(String addProvince) {
		this.addProvince = addProvince;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		if(registrationDate == null) this.registrationDate = new Date();
		else this.registrationDate = registrationDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getFullName() {
		setFullName();
		return this.fullName;
	}

	public void setFullName() {
		String mid= this.getMiddlename().trim();
		String suf = this.getSuffix().trim();
		StringBuffer f = new StringBuffer();
		f.append(this.getFirstname());
		f.append(StringHelper.isNotEmpty(mid) ? " "+mid+" " : " ");
		f.append(this.getLastname());
		f.append(StringHelper.isNotEmpty(suf) ?" "+suf : "");
		this.fullName = f.toString();
	}

	public String getErrorsConcat() {
		return errorsConcat;
	}

	public void setErrorsConcat(String errorsConcat) {
		this.errorsConcat = errorsConcat;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullImagePath() {
		return fullImagePath;
	}

	public void setFullImagePath(String fullImagePath) {
		this.fullImagePath = fullImagePath;
	}

}
