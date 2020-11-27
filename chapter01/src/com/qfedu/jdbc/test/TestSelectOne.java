package com.qfedu.jdbc.test;
import com.qfedu.jdbc.dao.StudentDao;
import com.qfedu.jdbc.domain.Student;
public class TestSelectOne {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		student.setSid(1);
		Student findStudent = studentDao.selectOne(student);
		System.out.println(findStudent.toString());
	}
}
