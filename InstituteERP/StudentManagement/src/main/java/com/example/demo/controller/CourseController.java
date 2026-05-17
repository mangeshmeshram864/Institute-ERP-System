package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CourseDto;
import com.example.demo.interfaces.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
   CourseService courseService;

	@PostMapping("course")
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto dto) {
		CourseDto savedCourse = courseService.createCourse(dto);

		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable int id, @RequestBody CourseDto dto) {
		CourseDto updatedCourse = courseService.updateCourse(id, dto);

		return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable int id) {
		CourseDto course = courseService.getCourse(id);

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@GetMapping("/getallcourses")
	public ResponseEntity<List<CourseDto>> getCourses() {
		List<CourseDto> courses = courseService.getCourses();

		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);

		return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
	}
	@GetMapping("/{userId}/courses")
	public ResponseEntity<List<CourseDto>> getUserCourses(@PathVariable int userId) {
	    return ResponseEntity.ok(courseService.getCoursesByUserId(userId));
	}
}
