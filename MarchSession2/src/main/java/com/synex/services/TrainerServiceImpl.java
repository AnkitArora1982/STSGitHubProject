package com.synex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Trainer;
import com.synex.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	TrainerRepository trainerRepository;

	@Override
	public Trainer saveTrainer(Trainer trainer) {
		return trainerRepository.save(trainer);
	}

}
