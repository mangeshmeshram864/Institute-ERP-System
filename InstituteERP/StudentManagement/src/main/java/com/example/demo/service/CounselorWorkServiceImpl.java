package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FollowUpDto;
import com.example.demo.dto.InquiryDto;
import com.example.demo.entity.Counsellor;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.FollowUp;
import com.example.demo.entity.Inquiry;
import com.example.demo.interfaces.CounselerWorkService;
import com.example.demo.repository.CounsellorRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.FollowUpRepository;
import com.example.demo.repository.InquiryRepository;

@Service
public class CounselorWorkServiceImpl implements CounselerWorkService {

	@Autowired
	private InquiryRepository inquiryRepo;

	@Autowired
	private CounsellorRepository counsellorRepo;

	@Autowired
	private FollowUpRepository followUpRepo;

	@Autowired
	private EnrollmentRepository enrollmentRepo;

	// Create Inquiry (Lead)
	public String createInquiry(InquiryDto dto) {

		Counsellor counsellor = counsellorRepo.findById(dto.getCounsellorId())
				.orElseThrow(() -> new RuntimeException("Counsellor not found"));

		Inquiry inquiry = new Inquiry();
		inquiry.setStudentName(dto.getStudentName());
		inquiry.setPhone(dto.getPhone());
		inquiry.setEmail(dto.getEmail());
		inquiry.setCourseInterested(dto.getCourseInterested());
		inquiry.setSource(dto.getSource());
		inquiry.setInquiryDate(dto.getInquiryDate());
		inquiry.setRemarks(dto.getRemarks());
		inquiry.setStatus("NEW");
		inquiry.setCounsellor(counsellor);

		inquiryRepo.save(inquiry);

		return "Inquiry created successfully";
	}

	// Add Follow-up
	public String addFollowUp(FollowUpDto dto) {

		Inquiry inquiry = inquiryRepo.findById(dto.getInquiryId())
				.orElseThrow(() -> new RuntimeException("Inquiry not found"));

		Counsellor counsellor = counsellorRepo.findById(dto.getCounsellorId())
				.orElseThrow(() -> new RuntimeException("Counsellor not found"));

		FollowUp followUp = new FollowUp();
		followUp.setInquiry(inquiry);
		followUp.setCounsellor(counsellor);
		followUp.setFollowupDate(dto.getFollowupDate());
		followUp.setNextFollowupDate(dto.getNextFollowupDate());
		followUp.setRemarks(dto.getRemarks());
		followUp.setStatus(dto.getStatus());

		inquiry.setStatus("FOLLOW_UP");

		followUpRepo.save(followUp);
		inquiryRepo.save(inquiry);

		return "Follow-up added successfully";
	}

	// Convert Inquiry to Enrollment
	public String convertToEnrollment(Long inquiryId) {

		Inquiry inquiry = inquiryRepo.findById(inquiryId).orElseThrow(() -> new RuntimeException("Inquiry not found"));

		// update inquiry status
		inquiry.setStatus("CONVERTED");

		// create enrollment
		Enrollment enrol = new Enrollment();
		enrol.setName(inquiry.getStudentName());
		enrol.setMobileNo(inquiry.getPhone());
		enrol.setStatus("ACTIVE");

		enrol.setTotalFees(20000.0);
		enrol.setPaidFees(0.0);
		enrol.setRemainigFees(20000.0);
		enrol.setReqFees(0.0);

		enrollmentRepo.save(enrol);
		inquiryRepo.save(inquiry);

		return "Lead converted to Enrollment successfully";
	}
}
