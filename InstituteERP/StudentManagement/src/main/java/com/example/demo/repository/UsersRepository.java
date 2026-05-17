package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    boolean existsByMobileNo(long mobileNo);

    boolean existsByMobileNoAndIdNot(long mobileNo, long id);

    Page<Users> findByRole(String role, Pageable pageable);
}