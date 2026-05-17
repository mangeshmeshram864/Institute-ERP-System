package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BatchDto {
	
	 private String batchName;
	 private LocalTime time;
	 private Integer capacity;
	 private Integer fees;
	 private LocalDate start_date;
	 private String mode;
	 private String status;
	 private Integer trainerId;
	 private Integer courseId;
	 
	 public Integer getCourseId() {
		return courseId;
	}
	 public void setCourseId(Integer courseId) {
		 this.courseId = courseId;
	 }
	 public Integer getTrainerId() {
		return trainerId;
	}
	 public void setTrainerId(Integer trainerId) {
		 this.trainerId = trainerId;
	 }
	 public String getBatchName() {
		 return batchName;
	 }
	 public void setBatchName(String batchName) {
		 this.batchName = batchName;
	 }
	 public LocalTime getTime() {
		 return time;
	 }
	 public void setTime(LocalTime time) {
		 this.time = time;
	 }
	
	 public Integer getCapacity() {
		return capacity;
	}
	 public void setCapacity(Integer capacity) {
		 this.capacity = capacity;
	 }
	 public Integer getFees() {
		 return fees;
	 }
	 public void setFees(Integer fees) {
		 this.fees = fees;
	 }
	 public LocalDate getStart_date() {
		 return start_date;
	 }
	 public void setStart_date(LocalDate start_date) {
		 this.start_date = start_date;
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

}
