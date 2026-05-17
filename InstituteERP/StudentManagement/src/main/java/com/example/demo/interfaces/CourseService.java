package com.example.demo.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CourseDto;

public interface CourseService {
 CourseDto createCourse(CourseDto dto);
 CourseDto getCourse(int id);
 List<CourseDto> getCourses();
 CourseDto updateCourse(int id,CourseDto dto);
 void deleteCourse(int id);
 public List<CourseDto> getCoursesByUserId(int userId);
 
 
}
