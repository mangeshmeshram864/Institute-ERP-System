
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BatchDto;
import com.example.demo.dto.BatchResponseDto;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Course;
import com.example.demo.entity.Trainer;
import com.example.demo.exception.BatchServiceException;
import com.example.demo.interfaces.BatchService;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.TrainerRepository;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	TrainerRepository trainerRepository;
	
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public void addBatch(BatchDto batchDto) {
		if (batchDto.getTrainerId() == null) {
	        throw new RuntimeException("Trainer ID is required");
	    }

	    Trainer trainer = trainerRepository.findById(batchDto.getTrainerId())
	            .orElseThrow(() -> new RuntimeException("Trainer not found"));
	    
	    if (batchDto.getCourseId() == null) {
	        throw new RuntimeException("Course ID is required");
	    }

	    Course course = courseRepository.findById(batchDto.getCourseId())
	            .orElseThrow(() -> new RuntimeException("Course not found"));
	    
		Batch batch = new Batch();
		batch.setBatchName(batchDto.getBatchName());
		batch.setCapacity(batchDto.getCapacity());
		batch.setTime(batchDto.getTime());
		batch.setFees(batchDto.getFees());
		batch.setStart_date(batchDto.getStart_date());
		batch.setMode(batchDto.getMode());
		batch.setStatus(batchDto.getStatus());
		
		batch.setTrainer(trainer);
		batch.setCourse(course);
		
		 /*if(batchRepository.existsById(batch.getId()))
		 {
			 throw new BatchServiceException("Batch not found", HttpStatus.NOT_FOUND);
		 }*/
		 
		batchRepository.save(batch);
	}

	@Override
	public void deleteBatch(int id) {
		// TODO Auto-generated method stub
		 if(!batchRepository.existsById(id))
		 {
			 throw new BatchServiceException("Batch not found", HttpStatus.NOT_FOUND);
		 }
		batchRepository.deleteById(id);	
	}

	@Override
	public void deleteBatches() {
		// TODO Auto-generated method stub
		batchRepository.deleteAll();
	}

	@Override
	public BatchResponseDto getBatch(int id) {

	    Batch batch = batchRepository.findById(id)
	            .orElseThrow(() -> new BatchServiceException("Batch is not present", HttpStatus.NOT_FOUND));

	    return convertToResponseDto(batch);
	}
	

		
		private BatchDto convertToDto(Batch batch) {

		BatchDto dto = new BatchDto();
		dto.setBatchName(batch.getBatchName());
		dto.setTime(batch.getTime());
		dto.setCapacity(batch.getCapacity());
		dto.setFees(batch.getFees());
		dto.setStart_date(batch.getStart_date());
		dto.setMode(batch.getMode());
		dto.setStatus(batch.getStatus());
		
		if (batch.getCourse() != null) {
		    dto.setCourseId(batch.getCourse().getId());
		}
		
		if (batch.getTrainer() != null) {
		    dto.setTrainerId(batch.getTrainer().getId());
		}
		

		return dto;
	}

	@Override
	public List<BatchResponseDto> getBatches() {
		return batchRepository.findAll()
	            .stream()
	            .map(this::convertToResponseDto)
	            .collect(Collectors.toList());
	}
		// TODO Auto-generated method stub
		/*List<Batch> batchList = batchRepository.findAll();
		List<BatchResponseDto> dtoList = new ArrayList<>();
		
		for(Batch batch : batchList)
		{
			BatchDto batchDto = new BatchDto();
			batchDto.setBatchName(batch.getBatchName());
			batchDto.setCapacity(batch.getCapacity());
			batchDto.setTime(batch.getTime());
			batchDto.setFees(batch.getFees());
			batchDto.setStart_date(batch.getStart_date());
			batchDto.setMode(batch.getMode());
			batchDto.setStatus(batch.getStatus());
			
			if (batch.getCourse() != null) {
				batchDto.setCourseId(batch.getCourse().getId());
			}
			
			if (batch.getTrainer() != null) {
				batchDto.setTrainerId(batch.getTrainer().getId());
			}
			
			dtoList.add(batchDto);
		}
		
		return dtoList;
	}*/

	@Override
	public List<BatchResponseDto> getBatchesByCourse(int courseId) {

	    return batchRepository.findByCourse_Id(courseId)
	            .stream()
	            .map(this::convertToResponseDto)   
	            .collect(Collectors.toList());   
	}
	private BatchResponseDto convertToResponseDto(Batch batch) {

	    BatchResponseDto dto = new BatchResponseDto();

	    dto.setBatchName(batch.getBatchName());
	    dto.setMode(batch.getMode());

	    dto.setStartDate(
	        batch.getStart_date() != null 
	            ? batch.getStart_date()
	            : null
	    );

	    dto.setStatus(batch.getStatus());
	    dto.setCapacity(batch.getCapacity());

	    dto.setTime(
	        batch.getTime() != null 
	            ? batch.getTime().toString() 
	            : null
	    );

	    if (batch.getTrainer() != null) {
	        dto.setTrainerName(batch.getTrainer().getName());
	    }

	    if (batch.getCourse() != null) {
	        dto.setCourseName(batch.getCourse().getName());
	    }

	    return dto;
	}
	@Override
	public List<BatchResponseDto> getBatchesByUserId(int userId) {

	    List<Batch> batches = enrollmentRepository.findBatchesByUserId(userId);

	    return batches.stream()
	            .map(this::convertToResponseDto)
	            .collect(Collectors.toList());
	}

	

}
