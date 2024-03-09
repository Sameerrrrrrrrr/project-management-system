package com.project.projectmanagementsystem.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.projectmanagementsystem.model.Project;
import com.project.projectmanagementsystem.service.ProjectService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjectService projectService;

    @Test
    public void testCreateProject() throws Exception {
        Project project = new Project(1,"Project Name", "Project Description",new Date(),new Date());
        Project createdProject = new Project(1, "Project Name", "Project Description",new Date(),new Date());

        Mockito.when(projectService.addProject(Mockito.any(Project.class))).thenReturn(createdProject);

        mockMvc.perform(post("/project/add-project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Project Name"))
                .andExpect(jsonPath("$.description").value("Project Description"));
    }
    @Test
    public void testGetProjectById() throws Exception {
        Project project = new Project(1, "Project Name", "Project Description",new Date(),new Date());

        Mockito.when(projectService.getProjectById(1)).thenReturn(project);

        mockMvc.perform(get("/project/get-project/{projectId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Project Name"))
                .andExpect(jsonPath("$.description").value("Project Description"));
    }

    @Test
    public void testUpdateProject() throws Exception {
        Project updatedProject = new Project(1, "Updated Project Name", "Updated Project Description",new Date(),new Date());

        Mockito.when(projectService.updateProject(Mockito.eq(1), Mockito.any(Project.class))).thenReturn(updatedProject);

        mockMvc.perform(put("/project/update-project/{projectId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedProject)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Updated Project Name"))
                .andExpect(jsonPath("$.description").value("Updated Project Description"));
    }

    @Test
    public void testDeleteProject() throws Exception {
        mockMvc.perform(delete("/project/delete-project/{projectId}", 1))
                .andExpect(status().isNoContent());
                
        Mockito.verify(projectService, Mockito.times(1)).deleteProject(Mockito.eq(1));
    }
    
}

