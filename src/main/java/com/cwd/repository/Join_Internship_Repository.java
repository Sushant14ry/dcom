package com.cwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.InternShip;

public interface Join_Internship_Repository extends JpaRepository<InternShip, Integer> {

	@Query(value = "SELECT * FROM join_interns WHERE studen_id = :stud_id ; ", nativeQuery = true)
	InternShip getJoinInternsStudentById(@Param("stud_id") int stud_id);
	
	@Query(value = "SELECT * FROM student_table st INNER JOIN join_interns ji WHERE st.stud_id = ji.studen_id AND ji.intern_joindate !='';", nativeQuery = true)
	List<Object> getInternJoinedAllStudents();
}
