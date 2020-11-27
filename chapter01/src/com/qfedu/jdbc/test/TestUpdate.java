package com.qfedu.jdbc.test;
import com.qfedu.jdbc.dao.StudentDao;
import com.qfedu.jdbc.domain.Student;
public class TestUpdate {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		student.setSid(10);
		student.setSname("zhouba");
		student.setAge("24");
		student.setCourse("Java");
		studentDao.update(student);
	}
}
