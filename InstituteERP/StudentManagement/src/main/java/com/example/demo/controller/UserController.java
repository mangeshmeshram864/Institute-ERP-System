package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsersDto;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersServiceImpl;



@CrossOrigin("http://localhost:5174")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UsersServiceImpl usersServiceImpl;
	@Autowired
    private UsersRepository usersRepository;

	@GetMapping("/hit")
	ResponseEntity<String> user() {
		return new ResponseEntity<String>("Logged in as user", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	ResponseEntity<Users> getUserById(@PathVariable long id) {
		Users user = usersServiceImpl.getUserById(id);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
//
//	@GetMapping
//	ResponseEntity<List<Users>> getAllUsers() {
//		List<Users> users = usersServiceImpl.getAllUsers();
//		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
//	}
	@GetMapping
	public ResponseEntity<Page<Users>> getAllUsers(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {

	    Page<Users> users = usersServiceImpl.getAllUsers(page, size);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	ResponseEntity<Users> updateUser(@PathVariable long id, @RequestBody UsersDto usersDto) {
		Users updatedUser = usersServiceImpl.updateUser(id, usersDto);
		return new ResponseEntity<Users>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteUser(@PathVariable long id) {
		usersServiceImpl.deleteUser(id);
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}
	@GetMapping("/{userId}/courses")
    public ResponseEntity<?> getUserCourses(@PathVariable Long userId) {

        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(user.getEnrollments());
    }
	
	@PutMapping("/status/{id}")
	public ResponseEntity<String> updateUserStatus(
	        @PathVariable long id,
	        @RequestParam(required = false) Boolean status) {

		if (status == null) {
	        return ResponseEntity.badRequest().body("Status parameter is required");
	    }
           Users user = usersRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(status);
	    usersRepository.save(user);

	    return ResponseEntity.ok("User status updated to " + status);
	}
}
