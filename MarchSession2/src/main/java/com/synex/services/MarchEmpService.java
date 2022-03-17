package com.synex.services;

import com.synex.domain.MarchEmp;

public interface MarchEmpService {
public MarchEmp saveEmp(MarchEmp marchEmp);
public MarchEmp findById(int id);
public MarchEmp findByName(String name);
}
