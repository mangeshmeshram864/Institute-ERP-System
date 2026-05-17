package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String name;
 private String duration;
 private String description;
 private String SyllabusLink;
 private String Prerequis;
 private String Status;
 @JsonManagedReference

 @OneToMany(mappedBy = "course")
 private List<Batch> batches;
 
 public List<Batch> getBatches() {
	return batches;
}
 public void setBatches(List<Batch> batches) {
	this.batches = batches;
 }
 public int getId() {
	return id;
 }
 public void setId(int id) {
	this.id = id;
 }
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
}
