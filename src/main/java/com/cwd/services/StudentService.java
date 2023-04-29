package com.cwd.services;

import java.util.List;

import com.cwd.model.Students;

public interface StudentService {

	boolean AddStudent(Students add_stud);
	
	boolean DelStudent(int sid);
	
	boolean UpdStudent(Students sid);
	
	Students getStudentById(String sid);
	List<Students> getALlStudent();
	List<Students> SearchStudent(String s_search);

}
