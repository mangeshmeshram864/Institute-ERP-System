
package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "followup_date")
    private LocalDate followupDate;

    @Column(name = "next_followup_date")
    private LocalDate nextFollowupDate;

    private String remarks;
    private String status;

    // Many follow-ups → one inquiry
    @ManyToOne
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;

    // Many follow-ups → one counsellor
    @ManyToOne
    @JoinColumn(name = "counsellor_id")
    private Counsellor counsellor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Inquiry getInquiry() {
		return inquiry;
	}

	public void setInquiry(Inquiry inquiry) {
		this.inquiry = inquiry;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

    
}
