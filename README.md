# Project Management System
This project is a simple implementation of a Project Management System using Spring Boot.
It provides CRUD (Create, Read, Update, Delete) operations for managing projects.

## Technologies Used
Java 17<br/>
Spring Boot
Spring Data JPA
H2 database
Maven
OpenAPI docs

## Features
Create Project - Create a new project with required details
Fetch Project - Retrieves project from the database if exists using Id
Fetch All Projects - Retrieves all projects from the db
Update Project - Updates project details 
Delete Project - Deletes the project details from database using Id

## Setup
1.Clone the repository
2.Navigate to the project directory
3.Build the project using maven
4.Run the application

The Application will be accessible at http://localhost:8080

## API Endpoints
1.GET /project/get-project/{projectId}: Retrieve details of a project by its ID.
2.POST /project/add-project: Create a new project.
3.PUT /projects/update-project/{projectId}: Update an existing project by its ID.
4.DELETE projects/delete-project/{projectId}: Delete a project by its ID.
5.GET /project/getAllProjects : Retrieves details of all projects.

## Documentation is done by using OpenAPI documentation
You can see it using the url:http://localhost:8080/swagger-ui/index.html










