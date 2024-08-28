package com.innspark.clickhouse_based.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.innspark.clickhouse_based.entity.Student;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<Student> ROW_MAPPER = new RowMapper<Student>() {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt("studentId"));
			student.setStudentName(rs.getString("studentName"));
			student.setAddress(rs.getString("address"));
			return student;
		}
	};

	/**
	 * for Create
	 */

	public Student createStudent(Student student) {
		String query = "insert into student(studentId,studentName,address)values (?,?,?) ";
		int updatedStudent = jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(),
				student.getAddress());
		System.err.println(updatedStudent);
		return student;
	}

	/**
	 * For Get-all-student
	 * 
	 * @return List<Student>
	 */
	public List<Student> getAllStudent() {
		String query = "select * from student";
		return jdbcTemplate.query(query, ROW_MAPPER);
	}

	/**
	 * For update student
	 * 
	 * @param studentId
	 * @return
	 */
	public Student updateStudent(Student student) {
		String sqlQuery = "update student set studentName=?,address=? where studentId=?";
		int update = jdbcTemplate.update(sqlQuery, student.getStudentId(), student.getStudentName(),
				student.getAddress());
		System.out.println(update + ":Affected -----------------------------------------------");
		return student;
	}

	/**
	 * For Find BY Student-id
	 */

	@SuppressWarnings("deprecation")
	public Student findByStudentId(Integer studentId) {
		String query = "select * from student where studentId=?";
		Student student = jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Student.class),
				studentId);
		// List<Student> studentList = jdbcTemplate.query(query, ROW_MAPPER);
		return student;
	}

	/**
	 * for Delete student
	 */
	public String deleteStudent(Integer studentId) {
		String query = "DELETE FROM student WHERE studentId=?";
		int update = jdbcTemplate.update(query, studentId);
		return update + " : value affected";
	}

	

}