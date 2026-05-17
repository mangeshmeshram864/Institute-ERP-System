package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Counsellor;

public interface CounsellorRepository extends JpaRepository<Counsellor, Long> {
}
