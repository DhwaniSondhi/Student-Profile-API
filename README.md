# Student-Profile-API
This API was developed to experiment with [rest-service](https://spring.io/guides/gs/rest-service/) and [JdbcTemplate](https://www.baeldung.com/spring-jdbc-jdbctemplate) in spring. It uses an annotation-based configuration.
It allows us to create, update, delete a student, and get the information of a specific or all the students using the data stored in MySQL.
It has an embedded Tomcat configured in [pom.xml](https://github.com/DhwaniSondhi/Student-Profile-API/blob/master/pom.xml) and is tested using [Postman](https://www.postman.com/).

## Prerequisites
- Java 8
- Eclipse IDE
- GIT
- Maven Plugin
- MySQL
- Postman

## How to run?
- Download/Clone the project from git.
- In MySQL, create a database named "practice" or change the URL in [ConfigurationFile.java](https://github.com/DhwaniSondhi/Student-Profile-API/blob/master/src/main/java/org/practice/ConfigurationFile.java).
- In the database, create a table with the command given in [createTable.txt](https://github.com/DhwaniSondhi/StudentProfile/blob/master/createTable.txt).
- Open the terminal.
- Use <code>mvn package cargo:run</code> to run the project.
- Open Postman and use the following commands to get, post, put, and delete a student:<br/>
  1. To get information of all the students- <code>GET: http://localhost:8080/StudentProfile/getStudents</code>
  2. To get information of a specific student- <code>GET: http://localhost:8080/StudentProfile/getStudent/{studentId}</code>
  3. To create a student(give the student JSON object in the body)- <code>POST: http://localhost:8080/StudentProfile/createStudent</code>
  4. To update a student(give the student JSON object in the body)- <code>PUT: http://localhost:8080/StudentProfile/updateStudent/{studentId}</code>
  5. To delete a student- <code>DELETE: http://localhost:8080/StudentProfile/deleteStudent/{studentId}</code>
