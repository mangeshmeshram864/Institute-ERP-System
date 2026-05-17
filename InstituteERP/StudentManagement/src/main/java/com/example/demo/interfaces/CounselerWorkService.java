package com.example.demo.interfaces;

import com.example.demo.dto.FollowUpDto;
import com.example.demo.dto.InquiryDto;


public interface CounselerWorkService {
	String createInquiry(InquiryDto dto);

	String addFollowUp(FollowUpDto dto);

	String convertToEnrollment(Long inquiryId);
}
