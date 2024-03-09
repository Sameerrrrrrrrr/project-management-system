package com.project.projectmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.project.projectmanagementsystem.model.Project;
import com.project.projectmanagementsystem.repository.ProjectRepo;




@Service
public class ProjectService {
	@Autowired
	private ProjectRepo projectRepo;
	
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}
	public void deleteProject(Integer id){
		Project project=projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project", "Project id", id));
		projectRepo.delete(project);
	}
	public Project getProjectById(Integer id){
		return projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project", "Project id", id));
	}
	public Project updateProject( Integer id, Project project) throws ResourceNotFoundException {
		Project updatedProject=this.getProjectById(id);
			updatedProject.setName(project.getName());
			updatedProject.setDescription(project.getDescription());
			updatedProject.setStartDate(project.getStartDate());
			updatedProject.setEndDate(project.getEndDate());
			return projectRepo.save(updatedProject);
	}
	public List<Project> getAllProjects() {
		return projectRepo.findAll();
	}
}
