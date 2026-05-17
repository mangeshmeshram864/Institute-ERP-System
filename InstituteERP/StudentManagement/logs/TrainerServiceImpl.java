package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TrainerDto;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Trainer;
import com.example.demo.exception.TrainerServiceException;
import com.example.demo.interfaces.TrainerService;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

    private final BatchRepository batchRepository;

    @Autowired
    TrainerRepository trainerRepository;

    TrainerServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public TrainerDto createTrainer(TrainerDto dto) {

        Trainer trainer = new Trainer();
        BeanUtils.copyProperties(dto, trainer);

        Trainer savedTrainer = trainerRepository.save(trainer);

        TrainerDto response = new TrainerDto();
        BeanUtils.copyProperties(savedTrainer, response);

        return response;
    }

    @Override
    public TrainerDto updateTrainer(int id, TrainerDto dto) {

    	Trainer trainer = trainerRepository.findById(id)
    	        .orElseThrow(() -> new TrainerServiceException("Trainer not found with id " + id, HttpStatus.NOT_FOUND));
                      

        trainer.setName(dto.getName());
        trainer.setExp(dto.getExp());
        trainer.setMobNo(dto.getMobNo());

        Trainer updatedTrainer = trainerRepository.save(trainer);

        TrainerDto response = new TrainerDto();
        BeanUtils.copyProperties(updatedTrainer, response);

        return response;
    }

    @Override
    public void deleteTrainer(int id) {

    	Trainer trainer = trainerRepository.findById(id)
    	        .orElseThrow(() -> new TrainerServiceException("Trainer not found with id " + id, HttpStatus.NOT_FOUND));
        trainerRepository.delete(trainer);
    }
    
    @Override
    public TrainerDto getTrainer(int id) {

    	Trainer trainer = trainerRepository.findById(id)
    	        .orElseThrow(() -> new TrainerServiceException("Trainer not found with id " + id, HttpStatus.NOT_FOUND));

        TrainerDto dto = new TrainerDto();
        BeanUtils.copyProperties(trainer, dto);

        return dto;
    }

    @Override
    public List<TrainerDto> getTrainers() {

        List<Trainer> trainers = trainerRepository.findAll();

        return trainers.stream().map(trainer -> {
            TrainerDto dto = new TrainerDto();
            BeanUtils.copyProperties(trainer, dto);
            return dto;
        }).collect(Collectors.toList());
    }

	@Override
	public String assignTrainerToBatch(int trainerId, int batchId) {
		// TODO Auto-generated method stub
		
		  Trainer trainer = trainerRepository.findById(trainerId)
	                .orElseThrow(() -> new RuntimeException("Trainer not found"));

	        Batch batch = batchRepository.findById(batchId)
	                .orElseThrow(() -> new RuntimeException("Batch not found"));
		
		 batch.setTrainer(trainer);

	       batchRepository.save(batch);

	        return "Trainer assigned to batch successfully";
		
	
	}
}

