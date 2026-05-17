package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Users;
import com.example.demo.exception.CourseServiceException;
import com.example.demo.interfaces.CourseService;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UsersRepository;

@Service

public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UsersRepository usersRepository;

	@Override
	public CourseDto createCourse(CourseDto dto) {
		// TODO Auto-generated method stub
		Course course = new Course();
        BeanUtils.copyProperties(dto, course);

        Course savedCourse = courseRepository.save(course);

        CourseDto response = new CourseDto();
        BeanUtils.copyProperties(savedCourse, response);
        response.setCourseId(savedCourse.getId());
        return response;
		
	}

	@Override
	public CourseDto getCourse(int id) {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new CourseServiceException("Course not found with id " + id));

        CourseDto response = new CourseDto();
        BeanUtils.copyProperties(course, response);
        response.setCourseId(course.getId());
        return response;
    }
	
	

	@Override
	public List<CourseDto> getCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = courseRepository.findAll();

        List<CourseDto> responseList = new ArrayList<>();

        for (Course course : courses) {

            CourseDto dto = new CourseDto();
            BeanUtils.copyProperties(course, dto);
            dto.setCourseId(course.getId());
            responseList.add(dto);
        }

        return responseList;
    }
		

	@Override
	public CourseDto updateCourse(int id, CourseDto dto) {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new CourseServiceException("Course not found with id " + id));

        course.setName(dto.getName());
        course.setDuration(dto.getDuration());
        course.setSyllabusLink(dto.getSyllabusLink());
        course.setStatus(dto.getStatus());
        course.setPrerequis(dto.getPrerequis());

        Course updatedCourse = courseRepository.save(course);

        CourseDto response = new CourseDto();
        BeanUtils.copyProperties(updatedCourse, response);
        response.setCourseId(updatedCourse.getId());
        return response;
		
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new CourseServiceException("Course not found with id " + id));

		courseRepository.delete(course);
		
	}
	/*public List<CourseDto> getCoursesByUserId(int userId) {

	    Users user = UsersRepository.findCoursesByuserId(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    return user.getCourses()
	            .stream()
	            .map(course -> {
	                CourseDto dto = new CourseDto();
	                dto.setCourseId(course.getId());
	                dto.setName(course.getName());
	                dto.setDescription(course.getDescription());
	                dto.setDuration(course.getDuration());
	                dto.setStatus(course.getStatus());
	                dto.setPrerequis(course.getPrerequis());
	                return dto;
	            })
	            .collect(Collectors.toList());
	}*/

	

	@Override
	public List<CourseDto> getCoursesByUserId(int userId) {

	    Users user = usersRepository.findById((long) userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    List<CourseDto> dtoList = new ArrayList<>();

	    for (Enrollment enrollment : user.getEnrollments()) {

	        Batch batch = enrollment.getBatch();
	        Course course = batch.getCourse();

	        CourseDto dto = new CourseDto();

	        dto.setCourseId(course.getId());
	        dto.setName(course.getName());
	        dto.setDescription(course.getDescription());
	        dto.setDuration(course.getDuration());
	        dto.setStatus(course.getStatus());
	        dto.setPrerequis(course.getPrerequis());

	        dtoList.add(dto);
	    }

	    return dtoList;
	}

}
