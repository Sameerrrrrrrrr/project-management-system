package com.project.projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.projectmanagementsystem.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer>{
	
}
