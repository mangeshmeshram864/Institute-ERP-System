package com.example.demo.dto;

public class CourseDto {
	 private int courseId;
	 private String name;
	 private String duration;
	 private String description;
	 private String SyllabusLink;
	 private String Prerequis;
	 private String Status;
	
	 public String getName() {
		return name;
	 }
	 public void setName(String name) {
		this.name = name;
	 }
	 public String getDuration() {
		return duration;
	 }
	 public void setDuration(String duration) {
		this.duration = duration;
	 }
	 public String getSyllabusLink() {
		return SyllabusLink;
	 }
	 public void setSyllabusLink(String syllabusLink) {
		SyllabusLink = syllabusLink;
	 }
	 public String getPrerequis() {
		return Prerequis;
	 }
	 public void setPrerequis(String prerequis) {
		Prerequis = prerequis;
	 }
	 public String getStatus() {
		return Status;
	 }
	 public void setStatus(String status) {
		Status = status;
	 }
	 public String getDescription() {
		return description;
	 }
	 public void setDescription(String description) {
		this.description = description;
	 }
	 public int getCourseId() {
		return courseId;
	 }
	 public void setCourseId(int courseId) {
		this.courseId = courseId;
	 }
	}

