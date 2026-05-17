package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FollowUpDto;
import com.example.demo.dto.InquiryDto;
import com.example.demo.interfaces.CounselerWorkService;
@RestController()
@RequestMapping("/counselor")
public class CounselerWorkController {
	@Autowired
	CounselerWorkService service;

	@PostMapping("/create-inquiry")
	public ResponseEntity<String> createInquiry(@RequestBody InquiryDto dto) {
		return ResponseEntity.ok(service.createInquiry(dto));
	}

	@PostMapping("/add-followup")
	public ResponseEntity<String> addFollowUp(@RequestBody FollowUpDto dto) {
		return ResponseEntity.ok(service.addFollowUp(dto));
	}

	// Convert to Enrollment
	@PutMapping("/convert/{id}")
	public ResponseEntity<String> convert(@PathVariable Long id) {
		return ResponseEntity.ok(service.convertToEnrollment(id));
	}
}
