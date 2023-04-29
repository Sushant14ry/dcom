package com.cwd.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.Exp_report;
import com.cwd.model.Expenses;

public interface Exp_Report_Repository extends JpaRepository<Exp_report, Integer> {

	@Query(value = "SELECT * FROM expenses_table WHERE exp_date BETWEEN ':from' AND ':to' ",nativeQuery = true)
	Expenses getFilterExpensesWithDate(@Param("from") Date from , @Param("to") Date to);
}
