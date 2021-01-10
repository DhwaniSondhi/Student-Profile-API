package org.practice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.practice.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private class StudentMapper implements RowMapper<Student>{
		
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Student.StudentBuilder()
					.setId(rs.getString("ID"))
					.setfName(rs.getString("FNAME"))
					.setlName(rs.getString("LNAME"))
					.setAddress(rs.getString("ADDRESS"))
					.build();
		}
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	public List<Student> getAllStudents() {
		String sql="SELECT * FROM student";
		return this.jdbcTemplate.query(sql, new StudentMapper());
	}
	public Student getStudent(String id) {
		String sql="SELECT * FROM student WHERE id=?";
		return this.jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
	}
	public void createStudent(Student student) {
		String sql="INSERT INTO student(id, fname, lname, address) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, student.getId(), student.getfName(), student.getlName(), student.getAddress());
	}
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub
		
	}
}
