package com.qfedu.jdbc.test;
import java.util.ArrayList;
import com.qfedu.jdbc.dao.StudentDao;
import com.qfedu.jdbc.domain.Student;
public class TestSelectAll {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> list = studentDao.selectAll();
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
}
