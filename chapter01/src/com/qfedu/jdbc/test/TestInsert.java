package com.qfedu.jdbc.test;
import com.qfedu.jdbc.dao.StudentDao;
import com.qfedu.jdbc.domain.Student;
public class TestInsert {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		student.setSid(10);
		student.setSname("sunqi");
		student.setAge("23");
		student.setCourse("Python");
		studentDao.insert(student);
	}
}
