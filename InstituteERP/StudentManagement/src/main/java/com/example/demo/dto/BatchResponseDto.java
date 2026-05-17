package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;


public class BatchResponseDto {
	private int id;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 private String batchName;
	    private String mode;
	    private LocalDate startDate;
	    private String status;

	    private String trainerName;
	    private String courseName;
	    private int capacity;
	    private String time;
		public String getBatchName() {
			return batchName;
		}
		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}
		public String getMode() {
			return mode;
		}
		public void setMode(String mode) {
			this.mode = mode;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate( LocalDate startDate) {
			this.startDate = startDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTrainerName() {
			return trainerName;
		}
		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public String getTime() {
			return time;
		}
		
		public void setTime(String time) {
		this.time=time;
			
		}
		
		
		
}
