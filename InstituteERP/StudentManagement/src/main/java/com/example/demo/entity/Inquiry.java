package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    private String phone;
    private String email;

    @Column(name = "course_interested")
    private String courseInterested;

    private String source;

    @Column(name = "inquiry_date")
    private LocalDate inquiryDate;

    private String status;
    private String remarks;

    // Many inquiries → one counsellor
    @ManyToOne
    @JoinColumn(name = "counsellor_id")
    private Counsellor counsellor;

    // One inquiry → many follow-ups
    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL)
    private List<FollowUp> followUps;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	public List<FollowUp> getFollowUps() {
		return followUps;
	}

	public void setFollowUps(List<FollowUp> followUps) {
		this.followUps = followUps;
	}
    
}