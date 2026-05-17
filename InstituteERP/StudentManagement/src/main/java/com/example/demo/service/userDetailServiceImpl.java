package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class userDetailServiceImpl implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> o = usersRepository.findByUsername(username);

		if (o.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}

		Users user = o.get();

		List<GrantedAuthority> lga = new ArrayList<>();

		for (String role : user.getRole().split(",")) {
			lga.add(new SimpleGrantedAuthority(role.trim()));
		}

		return new User(user.getUsername(), user.getPassword(), lga);
	}


	public void resetPassword(String email, String newPassword) {

		Users user = usersRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		user.setPassword(passwordEncoder.encode(newPassword));
		usersRepository.save(user);
	}

    public String getEmailByUsername(String username) {
        // assuming you have a UserRepository with a findByUsername method
        Optional<Users> user = usersRepository.findByUsername(username);
        return user.map(Users::getEmail).orElse("");
    }
    public Long getUserIdByUsername(String username) {
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getId();
    }
}