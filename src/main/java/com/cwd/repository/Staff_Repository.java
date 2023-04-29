package com.cwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwd.dto.SalaryDto;
import com.cwd.model.Staff;

public interface Staff_Repository extends JpaRepository<Staff, Integer> {
	
	@Query(value = "SELECT  COUNT(*) FROM staff_table;", nativeQuery = true)
	int getTotalStaff();
}
