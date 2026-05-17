package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsersDto;
import com.example.demo.dto.UsersRegistrationDto;
import com.example.demo.entity.Users;
import com.example.demo.exception.UsersServiceException;
import com.example.demo.interfaces.UsersServiceInt;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersServiceInt {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public void userRegisteration(UsersRegistrationDto usersRegistrationDto) {

		checksEmptyFields(usersRegistrationDto);

		if (usersRepository.existsByUsername(usersRegistrationDto.getUsername())) {
			throw new UsersServiceException("Username already exists", HttpStatus.CONFLICT);
		}
		if (usersRepository.existsByEmail(usersRegistrationDto.getEmail())) {
			throw new UsersServiceException("Email already exists", HttpStatus.CONFLICT);
		}
		if (usersRepository.existsByMobileNo(usersRegistrationDto.getMobileNo())) {
			throw new UsersServiceException("Mobile number already exists", HttpStatus.CONFLICT);
		}

		Users users = new Users();
		users.setUsername(usersRegistrationDto.getUsername());
		users.setFirstName(usersRegistrationDto.getFirstName());
		users.setLastName(usersRegistrationDto.getLastName());
		users.setEmail(usersRegistrationDto.getEmail());
		users.setMobileNo(usersRegistrationDto.getMobileNo());
		users.setPassword(passwordEncoder.encode(usersRegistrationDto.getPassword()));
		users.setDate(LocalDate.now());
		users.setRole("ROLE_USER");
		usersRepository.save(users);
	}

	@Override
	public Users getUserById(long id) {
		return usersRepository.findById(id)
				.orElseThrow(() -> new UsersServiceException("User not found with id: " + id, HttpStatus.NOT_FOUND));
	}

//	@Override
//	public List<Users> getAllUsers() {
//		return usersRepository.findAll();
//	}

	public Page<Users> getAllUsers(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return usersRepository.findByRole("ROLE_USER", pageable);
	}

	@Override
	public Users updateUser(long id, UsersDto usersDto) {
		Users existingUser = usersRepository.findById(id)
				.orElseThrow(() -> new UsersServiceException("User not found with id: " + id, HttpStatus.NOT_FOUND));

		if (usersRepository.existsByMobileNoAndIdNot(usersDto.getMobileNo(), id)) {
			throw new UsersServiceException("Mobile number already exists", HttpStatus.CONFLICT);
		}

		existingUser.setFirstName(usersDto.getFirstName());
		existingUser.setLastName(usersDto.getLastName());
		existingUser.setMobileNo(usersDto.getMobileNo());
		existingUser.setAddress(usersDto.getAddress());
		existingUser.setAge(usersDto.getAge());
		existingUser.setDateOfBirth(usersDto.getDateOfBirth());
		existingUser.setGender(usersDto.getGender());
		existingUser.setEducation(usersDto.getEducation());
		existingUser.setAdharNo(usersDto.getAdharNo());
		existingUser.setPassoutYear(usersDto.getPassoutYear());
		existingUser.setProfession(usersDto.getProfession());
		existingUser.setExpertise(usersDto.getExpertise());
		existingUser.setParentName(usersDto.getParentName());
		existingUser.setParentMobileNo(usersDto.getParentMobileNo());
		existingUser.setUsername(usersDto.getUsername());

		return usersRepository.save(existingUser);
	}

	@Override
	public void deleteUser(long id) {
		Users existingUser = usersRepository.findById(id)
				.orElseThrow(() -> new UsersServiceException("User not found with id: " + id, HttpStatus.NOT_FOUND));
		usersRepository.delete(existingUser);
	}

	private void checksEmptyFields(UsersRegistrationDto dto) {

		if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
			throw new UsersServiceException("Username is required", HttpStatus.BAD_REQUEST);
		}

		if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
			throw new UsersServiceException("Email is required", HttpStatus.BAD_REQUEST);
		}

		if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
			throw new UsersServiceException("Password is required", HttpStatus.BAD_REQUEST);
		}

		// ✅ correct mobile validation
		if (String.valueOf(dto.getMobileNo()).length() != 10) {
			throw new UsersServiceException("Mobile number must be 10 digits", HttpStatus.BAD_REQUEST);
		}
	}

//	@Override
//	public List<Users> getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
