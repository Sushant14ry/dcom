package com.cwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwd.model.Student_gallery;

public interface Stud_Gallery_Repository extends JpaRepository<Student_gallery, Integer> {

	@Query(value = "SELECT  COUNT(*) FROM student_gallery;", nativeQuery = true)
	int getTotalPhotos();
}
