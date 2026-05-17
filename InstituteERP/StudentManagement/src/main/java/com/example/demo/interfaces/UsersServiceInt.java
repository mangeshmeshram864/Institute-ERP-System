package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.UsersDto;
import com.example.demo.dto.UsersRegistrationDto;
import com.example.demo.entity.Users;

public interface UsersServiceInt {

	void userRegisteration(UsersRegistrationDto usersRegistrationDto);

	Users getUserById(long id);

//	List<Users> getAllUsers();
    Page<Users> getAllUsers(int page, int size);
	Users updateUser(long id, UsersDto usersDto);

	void deleteUser(long id);

}
