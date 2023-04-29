package com.cwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwd.model.Faculty;

public interface Faculty_Repository extends JpaRepository<Faculty, Integer> {
	
	@Query(value = "SELECT  COUNT(*) FROM faculty_table;", nativeQuery = true)
	int getTotalFaculty();
}
