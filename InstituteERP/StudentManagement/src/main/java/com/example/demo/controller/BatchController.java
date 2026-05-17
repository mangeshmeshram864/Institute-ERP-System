package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BatchDto;
import com.example.demo.dto.BatchResponseDto;
import com.example.demo.interfaces.BatchService;

@RestController
@RequestMapping("user")
public class BatchController {
	
	@Autowired
	BatchService batchService;
	
	@PostMapping("/addBatch")
	public ResponseEntity<String> addBatch(@RequestBody BatchDto batchDto)
	{
		batchService.addBatch(batchDto);
		return new ResponseEntity<>("Batch added successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteBatch/{id}")
	public ResponseEntity<String> deleteBatch(@PathVariable int id)
	{
		batchService.deleteBatch(id);
		return new ResponseEntity<>("Batch deleted",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllBatches")
	public ResponseEntity<String> deleteAllBatches()
	{
		batchService.deleteBatches();
		return new ResponseEntity<>("All batches deleted",HttpStatus.CREATED);
	}
	
	/*@GetMapping("/getBatch/{id}")
	public ResponseEntity<BatchResponseDto> getBatch(@PathVariable int id)
	{
		batchService.getBatch(id);
		return new ResponseEntity<Integer>(batchService.getBatch(id) , HttpStatus.OK);
	}*/
	@GetMapping("/batches/{userId}")
	public ResponseEntity<List<BatchResponseDto>> getBatchesByUserId(@PathVariable int userId) {
	    return ResponseEntity.ok(batchService.getBatchesByUserId(userId));
	}
	/*@GetMapping("/getAllBatches")
	public ResponseEntity<List<BatchResponseDto>> getAllBatch()
	{
		return new ResponseEntity<>(batchService.getBatches() , HttpStatus.OK);
	}*/
	@GetMapping("/batches/course/{courseId}")
	public ResponseEntity<List<BatchResponseDto>> getBatchesByCourse(@PathVariable int courseId) {
	    return new ResponseEntity<>(
	        batchService.getBatchesByCourse(courseId),
	        HttpStatus.OK
	    );
	
	}

}

