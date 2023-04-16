package com.dcs.brgy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcs.brgy.entity.CivilStatus;
import com.dcs.brgy.repository.CivilStatusRepository;

@Component
public class CivilStatusService {

	@Autowired
	CivilStatusRepository csRepo;
	
	public List<CivilStatus> getAll(){
		return csRepo.findAll();
	}
}
