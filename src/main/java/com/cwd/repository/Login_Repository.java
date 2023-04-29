package com.cwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cwd.model.Registration;

public interface Login_Repository extends JpaRepository<Registration, Integer> {
	
//	Registration findByEmailAndPass(String email, String psw);
	
	@Query(value = "SELECT * FROM `register_table` WHERE reg_email = :email AND reg_password = :psw ", nativeQuery=true)
	Registration Login_User(@Param("email") String email , @Param("psw") String psw);

}
