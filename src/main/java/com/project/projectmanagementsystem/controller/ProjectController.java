package com.project.projectmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.project.projectmanagementsystem.model.Project;
import com.project.projectmanagementsystem.service.ProjectService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@PostMapping("/add-project")
	public ResponseEntity<Project> addProject(@RequestBody @Valid Project project){
		Project addedProject=projectService.addProject(project);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedProject);
	}
	@DeleteMapping("/delete-project/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable Integer id){
		projectService.deleteProject(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@GetMapping("/get-project/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable @Valid Integer id) throws ResourceNotFoundException{
		Project project=projectService.getProjectById(id);		
			return ResponseEntity.status(HttpStatus.OK).body(project);
		
	}
	@PutMapping("/update-project/{id}")
	public ResponseEntity<Project> updateUser(@PathVariable @Valid Integer id,@RequestBody Project project) throws NotFoundException{
		Project updatedProject=projectService.updateProject(id, project);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProject);
	}
	@GetMapping("/getAllProjects")
	public ResponseEntity<List<Project>> getAllUsers(){
		List<Project> projectsList=projectService.getAllProjects();
		return ResponseEntity.status(HttpStatus.OK).body(projectsList);
	}
}
