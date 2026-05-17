package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.dto.EnrollmentDto;
import com.example.demo.entity.Enrollment;


public interface EnrollmentService {
	public void enrollment(EnrollmentDto enrollmentDto);
	public void deleteEnrollment(int id);
	public void updateEnrollment(int id, Enrollment updateEnrollment);
	public Enrollment getEnrollmentUser(int id);
	public List<Enrollment> enrollmentsUsers();
	public void cancelEnrollment(int id);

}