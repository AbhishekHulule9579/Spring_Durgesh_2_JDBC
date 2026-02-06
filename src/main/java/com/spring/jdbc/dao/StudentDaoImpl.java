package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		
		//insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        int i = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return i;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int change(Student student) {
		//update data
		String query="update student set name=? , city=? where id=?";
		int i = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return i;
	}

	@Override
	public int deletes(int studentId) {
		//delete operation
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}

	@Override
	public Student getStudent(int studentId) {
		// Get only one student data
		String query="select * from student where id=?";
		RowMapperImpl rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// selecting All student
		String query="Select * from student ";
		List<Student> student = this.jdbcTemplate.query(query,new RowMapperImpl());
		return student;
	}
	
}
