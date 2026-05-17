package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Enrollment;
import com.example.demo.interfaces.EnrollmentService;

@RestController
@RequestMapping("/admin")
public class EnrollmentAdminController {

	@Autowired
	EnrollmentService enrollmentService;


	@PutMapping("enrollment/update/{id}")
	public ResponseEntity<String> updateEnrollment(@PathVariable int id, @RequestBody Enrollment enrollement) {
		enrollmentService.updateEnrollment(id, enrollement);
		;
		return new ResponseEntity<String>("Enrollment are updated", HttpStatus.OK);

	}

	@DeleteMapping("enrollment/delete/{id}")
	public ResponseEntity<String> RemoveEnrollment(@PathVariable int id) {
		enrollmentService.deleteEnrollment(id);
		return new ResponseEntity<String>("Enrollment are deleted sucessfully", HttpStatus.OK);

	}

	@GetMapping("enrollment/{id}")
	public ResponseEntity<Enrollment> enrollment(@PathVariable int id) {
		return new ResponseEntity<Enrollment>(enrollmentService.getEnrollmentUser(id), HttpStatus.OK);

	}

	@GetMapping("enrollments")
	public ResponseEntity<List<Enrollment>> enrollments() {
		return new ResponseEntity<List<Enrollment>>(enrollmentService.enrollmentsUsers(), HttpStatus.OK);

	}
	
	@PutMapping("enrollment/cancel/{id}")
	public ResponseEntity<String> cancelEnrollment(@PathVariable int id) {

	    enrollmentService.cancelEnrollment(id);

	    return new ResponseEntity<>("Enrollment cancelled successfully", HttpStatus.OK);
	}

}
