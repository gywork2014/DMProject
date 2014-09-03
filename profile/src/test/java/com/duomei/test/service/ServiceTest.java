package com.duomei.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.duomei.bases.entity.StudentEntity;
import com.duomei.bases.service.getStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-common.xml","classpath:applicationContext-beans.xml"})
public class ServiceTest {
	
	@Autowired
	private getStudentService studentservice;
	
	@Test
	public void getStudent(){
		
		String student_id="123456";
		StudentEntity student=studentservice.getStudentinfo(student_id);
		
		System.out.println(student .getStudent_id() +"  " +student.getStudent_name());
	}

}
