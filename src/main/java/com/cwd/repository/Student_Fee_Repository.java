package com.cwd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.Student_Fee;

public interface Student_Fee_Repository extends JpaRepository<Student_Fee, Integer> {

	@Query(value = "SELECT * FROM student_fee_table WHERE student_id =:stud_id",nativeQuery = true)
	List<Student_Fee> getStudentPaymentDetailsById(@Param("stud_id") int stud_id);
	
	@Query(value = "SELECT SUM(stud_fee_amount) from student_fee_table WHERE student_id =:stud_id ", nativeQuery = true)
	int getStudentTotalAmountById(@Param("stud_id") int stud_id);
	
	@Query(value = "SELECT * FROM student_fee_table WHERE stud_fee_id  =:stud_id",nativeQuery = true)
	List<Student_Fee> getStudentPaymentFeeDetailsById(@Param("stud_id") int stud_id);
	
	
	/* Annual Report Section Start */
	@Query(value = "SELECT SUM(stud_fee_amount) from student_fee_table ", nativeQuery = true)
	int getStudentTotalAmount();
}

