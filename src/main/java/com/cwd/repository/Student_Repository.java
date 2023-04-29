package com.cwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.Students;

public interface Student_Repository extends JpaRepository<Students, Integer> {

	@Query(value = "SELECT  COUNT(*) FROM student_table", nativeQuery = true)
	int getTotalStudent();
	
	@Query(value = "SELECT  COUNT(*) FROM student_table WHERE stud_faculty =:dca", nativeQuery = true )
	String getDCATotalStudent(@Param("dca") String dca);
	
	@Query(value = "SELECT  COUNT(*) FROM student_table WHERE stud_faculty =:dhm ", nativeQuery = true )
	String getDHMTotalStudent(@Param("dhm") String dhm);
	
	@Query(value = "SELECT  COUNT(*) FROM student_table WHERE stud_batch_year =:year", nativeQuery = true )
	int getTotalStudent(@Param("year") int year);

}
