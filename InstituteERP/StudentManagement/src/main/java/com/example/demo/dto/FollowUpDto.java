package com.example.demo.dto;

import java.time.LocalDate;

public class FollowUpDto {

    private Long inquiryId;
    private Long counsellorId;
    private LocalDate followupDate;
    private LocalDate nextFollowupDate;
    private String remarks;
    private String status;
    
	public Long getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}
	public Long getCounsellorId() {
		return counsellorId;
	}
	public void setCounsellorId(Long counsellorId) {
		this.counsellorId = counsellorId;
	}
	public LocalDate getFollowupDate() {
		return followupDate;
	}
	public void setFollowupDate(LocalDate followupDate) {
		this.followupDate = followupDate;
	}
	public LocalDate getNextFollowupDate() {
		return nextFollowupDate;
	}
	public void setNextFollowupDate(LocalDate nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    

}