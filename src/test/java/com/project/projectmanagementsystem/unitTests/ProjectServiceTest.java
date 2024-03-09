package com.project.projectmanagementsystem.unitTests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.projectmanagementsystem.exceptions.ResourceNotFoundException;
import com.project.projectmanagementsystem.model.Project;
import com.project.projectmanagementsystem.repository.ProjectRepo;
import com.project.projectmanagementsystem.service.ProjectService;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {
	
		 @Mock
		 private ProjectRepo projectRepository;
	
		 @InjectMocks
		 private ProjectService projectService;
		 
	
	 	@Test
	 	public void testCreateProject() {
        // Arrange
        Project project = new Project(1,"Name 1" ,"Description 1",new Date(),new Date());
        when(projectRepository.save(project)).thenReturn(project);

        // Act
        Project result = projectService.addProject(project);

        // Assert
        Assertions.assertEquals(project, result);
        verify(projectRepository, times(1)).save(project);
	 	}
	 	
	 	 @Test
	     public void testGetProjectById() {
	         // Arrange
	         Integer projectId = 1;
	         Project project = new Project(projectId, "Project 1", "Description 1",new Date(),new Date());
	         when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

	         // Act
	         Project result = projectService.getProjectById(projectId);

	         // Assert
	         Assertions.assertEquals(project, result);
	         verify(projectRepository, times(1)).findById(projectId);
	     }
	 	 @Test
	     public void testGetProjectById_ProjectNotFound() {
	         // Arrange
	         Integer projectId = 1;
	         when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

	         // Act & Assert
	         Assertions.assertThrows(ResourceNotFoundException.class, () -> projectService.getProjectById(projectId));
	         verify(projectRepository, times(1)).findById(projectId);
	     }
	 	@Test
	    public void testUpdateProject() {
	        // Arrange
	        Integer projectId = 1;
	        Project existingProject = new Project(projectId, "Project 1", "Description 1",new Date(),new Date());
	        Project updatedProject = new Project(projectId, "Updated Project 1", "Updated Description 1",new Date(),new Date());

	        when(projectRepository.findById(projectId)).thenReturn(Optional.of(existingProject));
	        when(projectRepository.save(existingProject)).thenReturn(updatedProject);

	        // Act
	        Project result = projectService.updateProject(projectId, updatedProject);

	        // Assert
	        Assertions.assertEquals(updatedProject, result);
	        verify(projectRepository, times(1)).findById(projectId);
	        verify(projectRepository, times(1)).save(existingProject);
	    }
	 	@Test
	    public void testDeleteProject() {
	        // Arrange
	        Integer projectId = 1;
	        Project project = new Project(projectId, "Project 1", "Description 1",new Date(),new Date());
	        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

	        // Act
	        projectService.deleteProject(projectId);

	        // Assert
	        verify(projectRepository, times(1)).findById(projectId);
	        verify(projectRepository, times(1)).delete(project);
	    }
	
}
	
	
	
	

