package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import com.synex.domain.MarchEmp;
import com.synex.domain.Trainer;
import com.synex.services.MarchEmpServiceImpl;
import com.synex.services.TrainerServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	MarchEmpServiceImpl marchEmpServiceImpl;

	@Autowired
	TrainerServiceImpl trainerServiceImpl;

	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<MarchEmp> saveEmployee(@RequestBody JsonNode json) {
		System.out.println(json+"json..................");
		int empId = json.get("id").asInt();
		String empName = json.get("name").asText();
		int empAge = json.get("age").asInt();
		MarchEmp emp = new MarchEmp();
		emp.setId(empId);
		emp.setName(empName);
		emp.setAge(empAge);
		MarchEmp marchEmp = marchEmpServiceImpl.saveEmp(emp);
		return new ResponseEntity<MarchEmp>(marchEmp, HttpStatus.OK);

	}

	@GetMapping(value = "/getEmp/{empId}")
	public MarchEmp getEmp(@PathVariable("empId") int empId) {
		return marchEmpServiceImpl.findById(empId);

	}

	@GetMapping(value = "/getEmpName/{empName}")
	public MarchEmp getEmpByName(@PathVariable("empName") String empName) {
		return marchEmpServiceImpl.findByName(empName);

	}

	@PostMapping(value = "/saveTrainer")
	public Trainer saveTrainer(@RequestBody JsonNode json) {

		int trainerId = json.get("trainerId").asInt();
		String trainerName = json.get("trainerName").asText();
		int trainerAge = json.get("trainerAge").asInt();
		int empId = json.get("empId").asInt();
		MarchEmp marchEmp = marchEmpServiceImpl.findById(empId);
		Trainer trainer = new Trainer();
		trainer.setId(trainerId);
		trainer.setName(trainerName);
		trainer.setAge(trainerAge);
		List<MarchEmp> list = new ArrayList<MarchEmp>();
		list.add(marchEmp);
		trainer.setMarchEmp(list);
		return trainerServiceImpl.saveTrainer(trainer);

	}
	
	@GetMapping(value = "/success")
	public String success() {
		return "success";

	}
}
