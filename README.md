# Project Management System
This project is a simple implementation of a Project Management System using Spring Boot.
It provides CRUD (Create, Read, Update, Delete) operations for managing projects.

## Technologies Used
Java 17<br/>
Spring Boot<br/>
Spring Data JPA<br/>
H2 database<br/>
Maven<br/>
OpenAPI docs<br/>

## Features
Create Project - Create a new project with required details<br/>
Fetch Project - Retrieves project from the database if exists using Id<br/>
Fetch All Projects - Retrieves all projects from the db<br/>
Update Project - Updates project details <br/>
Delete Project - Deletes the project details from database using Idv

## Setup
1.Clone the repository<br/>
2.Navigate to the project directory<br/>
3.Build the project using maven<br/>
4.Run the application<br/>

The Application will be accessible at http://localhost:8080<br/>

## API Endpoints
1.GET /project/get-project/{projectId}: Retrieve details of a project by its ID.<br/>
2.POST /project/add-project: Create a new project.<br/>
3.PUT /projects/update-project/{projectId}: Update an existing project by its ID.<br/>
4.DELETE projects/delete-project/{projectId}: Delete a project by its ID.<br/>
5.GET /project/getAllProjects : Retrieves details of all projects.<br/>

## Documentation is done by using OpenAPI documentation
You can see it using the url:http://localhost:8080/swagger-ui/index.html<br/>










