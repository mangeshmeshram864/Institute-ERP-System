package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Batch;
import com.example.demo.entity.Enrollment;
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	@Query("SELECT e.batch FROM Enrollment e WHERE e.user.id = :userId")
	List<Batch> findBatchesByUserId(@Param("userId") int userId);

	boolean existsByUser_IdAndBatch_Id(long userId, int batchId);
}
