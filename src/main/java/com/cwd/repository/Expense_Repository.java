package com.cwd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.Expenses;

public interface Expense_Repository extends JpaRepository<Expenses, Integer> {

	@Query(value = "SELECT * FROM expenses_table WHERE exp_date BETWEEN :from AND :to ",nativeQuery = true)
	List<Expenses> getFilterExpensesWithDate(@Param("from") String from , @Param("to") String to);
}
