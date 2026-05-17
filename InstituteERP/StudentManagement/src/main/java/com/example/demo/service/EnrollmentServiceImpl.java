package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EnrollmentDto;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Users;
import com.example.demo.exception.UsersServiceException;
import com.example.demo.interfaces.EnrollmentService;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.UsersRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	@Autowired
	BatchRepository batchRepository;
	@Autowired
	UsersRepository userRepository;

	@Override
	public void enrollment(EnrollmentDto enrollmentDto) {

	    if (enrollmentDto.getBatchId() == 0 || 
	        enrollmentDto.getUserId() == 0 || 
	        enrollmentDto.getMode() == null) {

	        throw new UsersServiceException("Please provide required fields", HttpStatus.BAD_REQUEST);
	    }

	   
	    if (enrollmentRepository.existsByUser_IdAndBatch_Id(
	            enrollmentDto.getUserId(), 
	            enrollmentDto.getBatchId())) {

	        throw new UsersServiceException(
	            "User already enrolled in this batch", 
	            HttpStatus.BAD_REQUEST
	        );
	    }

	   
	    Batch batch = batchRepository.findById(enrollmentDto.getBatchId())
	            .orElseThrow(() -> new UsersServiceException("Batch not found", HttpStatus.NOT_FOUND));

	   
	    Users user = userRepository.findById(enrollmentDto.getUserId())
	            .orElseThrow(() -> new UsersServiceException("User not found", HttpStatus.NOT_FOUND));

	    Enrollment enrollement = new Enrollment();

	    enrollement.setBatch(batch);
	    enrollement.setUser(user);
	    enrollement.setMode(enrollmentDto.getMode());
	    enrollement.setEnrollmentDate(enrollmentDto.getLocalDate());

	    enrollmentRepository.save(enrollement);
	}

	@Override
	public void deleteEnrollment(int id) {
		if (!enrollmentRepository.existsById(id)) {

			throw new UsersServiceException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}

		enrollmentRepository.deleteById(id);

	}

	@Override
	public void updateEnrollment(int id, Enrollment updateEnrollment) {
		if (!enrollmentRepository.existsById(id)) {

			throw new UsersServiceException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);
		}

		Enrollment existEnrollment = enrollmentRepository.findById(id).get();

		existEnrollment.setExtendedDueDate(updateEnrollment.getExtendedDueDate());

		existEnrollment.setFeesDueDate(updateEnrollment.getFeesDueDate());

		existEnrollment.setLiveSessionAccess(updateEnrollment.getLiveSessionAccess());

		existEnrollment.setMode(updateEnrollment.getMode());

		existEnrollment.setPaidFees(updateEnrollment.getPaidFees());

		existEnrollment.setRecordingAccess(updateEnrollment.getRecordingAccess());

		existEnrollment.setRemainigFees(updateEnrollment.getRemainigFees());

		existEnrollment.setStatus(updateEnrollment.getStatus());

		existEnrollment.setTotalFees(updateEnrollment.getTotalFees());

		enrollmentRepository.save(existEnrollment);
	}

	@Override
	public Enrollment getEnrollmentUser(int id) {
		if (!enrollmentRepository.existsById(id)) {

			throw new UsersServiceException("This Enrollement Are Not Exist", HttpStatus.NOT_FOUND);

		}

		return enrollmentRepository.findById(id).get();

	}

	@Override
	public List<Enrollment> enrollmentsUsers() {
		if (enrollmentRepository.findAll().isEmpty()) {

			throw new UsersServiceException("No Records Available", HttpStatus.NOT_FOUND);

		}

		return enrollmentRepository.findAll();
	}
	
	@Override
	public void cancelEnrollment(int id) {

	    Enrollment enrollment = enrollmentRepository.findById(id)
	            .orElseThrow(() -> new UsersServiceException("Enrollment not found", HttpStatus.NOT_FOUND));

	    // check if already cancelled
	    if ("CANCELLED".equalsIgnoreCase(enrollment.getStatus())) {
	        throw new UsersServiceException("Enrollment already cancelled", HttpStatus.BAD_REQUEST);
	    }

	    // update status
	    enrollment.setStatus("CANCELLED");

	    // optional: remove access
	    enrollment.setLiveSessionAccess(false);
	    enrollment.setRecordingAccess(false);

	    enrollmentRepository.save(enrollment);
	}

}