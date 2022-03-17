package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.MarchEmp;
import com.synex.repository.MarchEmpRepository;

@Service
public class MarchEmpServiceImpl implements MarchEmpService{
	
	@Autowired
	MarchEmpRepository marchEmpRepository;
	
	@Override
	public MarchEmp saveEmp(MarchEmp marchEmp) {
		return marchEmpRepository.save(marchEmp);
		
	}

	public MarchEmp findById(int id) {
		return marchEmpRepository.findById(id).orElse(null);
	}

	@Override
	public MarchEmp findByName(String name) {
		return marchEmpRepository.findByName(name);
	}

}
