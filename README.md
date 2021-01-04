# Student-Profile-API
Basic API for accessing students' profiles using Spring Rest and embedded Tomcat

This API was created to learn and practice the basics of [spring-rest-service](https://spring.io/guides/gs/rest-service/). It uses an XML-based configuration.
The API allows to see the information of all students or a specific one, add, edit, and delete an student. 
It has an embedded Tomcat configured in [pom.xml](https://github.com/DhwaniSondhi/Student-Profile-API/blob/master/pom.xml).
This API is tested using [Postman](https://www.postman.com/).

## Prerequisites
- Java 8
- Eclipse IDE
- GIT
- Maven Plugin
- Postman

## How to run?
- Download/Clone the project from git.
- Open terminal inside the project location.
- Use <code>mvn package cargo:run</code> to run the project.
- Open Postman and use following commands to get, post, put and delete an student:<br/>
  1. To get information of all the students- <code>GET: http://localhost:8080/StudentProfile/getStudents</code>
  2. To get information of an student- <code>GET: http://localhost:8080/StudentProfile/getStudent/{studentId}</code>
  3. To add an student(give the student JSON object in body)- <code>POST: http://localhost:8080/StudentProfile/addStudent</code>
  4. To edit an student(give the student JSON object in body)- <code>PUT: http://localhost:8080/StudentProfile/editStudent/{studentId}</code>
  5. To delete an student- <code>DELETE: http://localhost:8080/StudentProfile/deleteStudent/{studentId}</code>