package com.example.demo.dto;

import java.time.LocalDate;

public class InquiryDto {

    private String studentName;
    private String phone;
    private String email;
    private String courseInterested;
    private String source;
    private LocalDate inquiryDate;
    private String remarks;
    private Long counsellorId;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourseInterested() {
		return courseInterested;
	}
	public void setCourseInterested(String courseInterested) {
		this.courseInterested = courseInterested;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public LocalDate getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(LocalDate inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getCounsellorId() {
		return counsellorId;
	}
	public void setCounsellorId(Long counsellorId) {
		this.counsellorId = counsellorId;
	}
    
    

}