package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;
	private String mode;
	private String status;
	private Boolean liveSessionAccess;
	private Boolean recordingAccess;
	private Double totalFees;
	private Double paidFees;
	private Double remainigFees;
	private LocalDate feesDueDate;
	private LocalDate extendedDueDate;
	private String name;
    private String lastName;
    private String mobileNo;
    private Double reqFees; 
    
    @ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getReqFees() {
		return reqFees;
	}

	public void setReqFees(Double reqFees) {
		this.reqFees = reqFees;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	private Boolean approved;
	

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getLiveSessionAccess() {
		return liveSessionAccess;
	}

	public void setLiveSessionAccess(Boolean liveSessionAccess) {
		this.liveSessionAccess = liveSessionAccess;
	}

	public Boolean getRecordingAccess() {
		return recordingAccess;
	}

	public void setRecordingAccess(Boolean recordingAccess) {
		this.recordingAccess = recordingAccess;
	}

	

	public Double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Double totalFees) {
		this.totalFees = totalFees;
	}

	public Double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(Double paidFees) {
		this.paidFees = paidFees;
	}

	public Double getRemainigFees() {
		return remainigFees;
	}

	public void setRemainigFees(Double remainigFees) {
		this.remainigFees = remainigFees;
	}

	public LocalDate getFeesDueDate() {
		return feesDueDate;
	}

	public void setFeesDueDate(LocalDate feesDueDate) {
		this.feesDueDate = feesDueDate;
	}

	public LocalDate getExtendedDueDate() {
		return extendedDueDate;
	}

	public void setExtendedDueDate(LocalDate extendedDueDate) {
		this.extendedDueDate = extendedDueDate;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}