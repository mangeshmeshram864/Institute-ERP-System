package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.dto.BatchDto;
import com.example.demo.dto.BatchResponseDto;

public interface BatchService {
	
	public void addBatch(BatchDto batchDto);
	
	public void deleteBatch(int id);
	
	public void deleteBatches();
	
	BatchResponseDto getBatch(int id);
	
	List<BatchResponseDto> getBatches();
	
	


	List<BatchResponseDto> getBatchesByUserId(int userId);

	List<BatchResponseDto> getBatchesByCourse(int courseId);
}
