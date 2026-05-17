package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FollowUp;

public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {
}
