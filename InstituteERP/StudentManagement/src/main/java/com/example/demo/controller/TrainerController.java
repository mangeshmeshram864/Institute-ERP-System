package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TrainerDto;
import com.example.demo.entity.Trainer;
import com.example.demo.interfaces.TrainerService;	


@RestController
@RequestMapping("/admin")
public class TrainerController {
	
	@Autowired
	TrainerService trainerservice;
	@PostMapping("/createTrainer")
	public ResponseEntity<TrainerDto> createTrainer(@RequestBody TrainerDto dto)
	{
		
		TrainerDto savedTrainer = trainerservice.createTrainer(dto);
		
		return new ResponseEntity<>(savedTrainer,HttpStatus.CREATED);
	}
	
  @PutMapping("/updateTrainer/{id}")
	public ResponseEntity<TrainerDto> updateTrainer(@PathVariable int id,@RequestBody TrainerDto dto)
	{
		
		
		TrainerDto updatedTrainer = trainerservice.updateTrainer(id, dto);
		return new ResponseEntity<>( updatedTrainer,HttpStatus.OK);
	}
	@DeleteMapping("/deleteTrainer/{id}")
	public ResponseEntity<String> deleteTrainer(@PathVariable int id)
	{
		trainerservice.deleteTrainer(id);
		return new ResponseEntity<>("Trainer deleted Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getTrainer/{id}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable int id)
	{
		Trainer trainer = trainerservice.getTrainer(id);
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	  @GetMapping("/getTrainers")
	public ResponseEntity<List<Trainer>> getTrainers()
	{
		
		List<Trainer> trainers = trainerservice.getTrainers();
		
		return new ResponseEntity<>(trainers,HttpStatus.OK);
	}
	  
	  
	  @PutMapping("/{trainerId}/assign/batch/{batchId}")
	    public ResponseEntity<String> assignTrainer(
	            @PathVariable int trainerId,
	            @PathVariable int batchId) {

	        String response = trainerservice.assignTrainerToBatch(trainerId, batchId);

	        return ResponseEntity.ok(response);
	    }

}

