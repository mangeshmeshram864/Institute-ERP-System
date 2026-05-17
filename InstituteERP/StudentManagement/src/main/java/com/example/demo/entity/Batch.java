package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch_table")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String batchName;
	private LocalTime time;
	private Integer capacity;
	private Integer fees;
	private LocalDate start_date;
	private String mode;
	private String status;

	@ManyToOne
	@JoinColumn(name = "trainerId")
	@JsonManagedReference
	private Trainer trainer;

	@ManyToOne
	@JoinColumn(name = "courseId")
  @JsonIgnore
	private Course course;

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public void setFees(Integer fees) {
		this.fees = fees;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public Integer getFees() {
		return fees;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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

	public void setTrainer(Trainer trainer) {
		// TODO Auto-generated method stub

	}

}
