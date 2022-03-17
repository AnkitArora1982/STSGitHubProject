package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synex.domain.MarchEmp;

@Repository
public interface MarchEmpRepository extends JpaRepository<MarchEmp, Integer>{
	MarchEmp findByName(String name);
	MarchEmp findByAge(int age);
}
