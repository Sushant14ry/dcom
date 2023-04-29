package com.cwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwd.model.Intern_Doccument;

public interface Internship_Repository extends JpaRepository<Intern_Doccument, Integer> {
	
	@Query(value = "SELECT * FROM intern_doccument WHERE intern_id =:stud_id ", nativeQuery = true)
	Intern_Doccument getInternshipStudentById(@Param("stud_id") int stud_id);
	
	@Query(value = "SELECT  COUNT(*) FROM intern_doccument;", nativeQuery = true)
	int getTotalInterns();
}
