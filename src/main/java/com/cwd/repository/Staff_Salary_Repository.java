package com.cwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.Stf_salary;

public interface Staff_Salary_Repository extends JpaRepository<Stf_salary, Integer> {

	@Query(value = "SELECT * FROM staff_salary WHERE staff_id =:stf_id",nativeQuery = true)
	List<Stf_salary> getStaffSalaryDetailsById(@Param("stf_id") int stf_id );
}
