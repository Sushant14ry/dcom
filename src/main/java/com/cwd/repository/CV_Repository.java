package com.cwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwd.model.CV_Model;

public interface CV_Repository extends JpaRepository<CV_Model, Integer> {

}
