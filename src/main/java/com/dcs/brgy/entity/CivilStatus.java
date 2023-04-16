package com.dcs.brgy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CIVIL_STATUS")
public class CivilStatus {
	@Id
	@Column(name = "CIVIL_STATUS_CODE")
	private String civilStatusCde;
	@Column(name = "CIVIL_STATUS_DESCRIPTION")
	private String civilStatusDesc;

	public String getCivilStatusCde() {
		return civilStatusCde;
	}

	public void setCivilStatusCde(String civilStatusCde) {
		this.civilStatusCde = civilStatusCde;
	}

	public String getCivilStatusDesc() {
		return civilStatusDesc;
	}

	public void setCivilStatusDesc(String civilStatusDesc) {
		this.civilStatusDesc = civilStatusDesc;
	}

}
