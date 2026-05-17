package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.demo.config.JwtUtil;
import com.example.demo.interfaces.EmailService;
import com.example.demo.service.userDetailServiceImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	userDetailServiceImpl usersDetailServiceImpl;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private EmailService emailService;

	
	private Map<String, String> otpStorage = new HashMap<>();

	
	@PostMapping("/login/{username}/{password}")
	public ResponseEntity<Map<String, Object>> register(@PathVariable String username, @PathVariable String password) {

		UserDetails userDetails = usersDetailServiceImpl.loadUserByUsername(username);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		Map<String, Object> r = new HashMap<>();
		r.put("Token", jwtUtil.generateToken(userDetails));
		r.put("Roles", userDetails.getAuthorities().stream().map(a -> a.getAuthority()).toList());
		r.put("Username", userDetails.getUsername());
		r.put("Email", usersDetailServiceImpl.getEmailByUsername(username));
		r.put("userId", usersDetailServiceImpl.getUserIdByUsername(username));
		return new ResponseEntity<>(r, HttpStatus.OK);
	}

	
	@PostMapping("/send-otp")
	public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> req) {

		String email = req.get("email");

		String otp = String.valueOf(new java.util.Random().nextInt(900000) + 100000);

		System.out.println("OTP is: " + otp);

		try {
			otpStorage.put(email, otp);

			emailService.sendOtp(email, otp);

			return ResponseEntity.ok("OTP sent successfully");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send OTP");
		}
	}

	
	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtp(@RequestBody Map<String, String> req) {

		String email = req.get("email");
		String otp = req.get("otp");

		String storedOtp = otpStorage.get(email);

		// No OTP found
		if (storedOtp == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No OTP found. Please request again.");
		}

		// Wrong OTP
		if (!storedOtp.equals(otp)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
		}

		// Remove OTP after success
		otpStorage.remove(email);

		return ResponseEntity.ok("OTP verified successfully");
	}

	// RESET PASSWORD
	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> request) {
		String email = request.get("email");
		String newPassword = request.get("newPassword");

		usersDetailServiceImpl.resetPassword(email, newPassword);

		return ResponseEntity.ok("Password reset successful");
	}

}