package com.example.demo.interfaces;
import java.util.List;

import com.example.demo.dto.TrainerDto;
import com.example.demo.entity.Trainer;


public interface TrainerService {

    TrainerDto createTrainer(TrainerDto dto);

    TrainerDto updateTrainer(int id, TrainerDto dto);

    void deleteTrainer(int id);
    
    Trainer getTrainer(int id);

    List<Trainer> getTrainers();
    
    public String assignTrainerToBatch(int trainerId, int batchId);
    
}
	


