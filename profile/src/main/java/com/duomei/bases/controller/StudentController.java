package com.duomei.bases.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duomei.bases.entity.StudentEntity;
import com.duomei.bases.service.getStudentService;


@Controller
public class StudentController {
	
  
	@Autowired
	private getStudentService service;
	
	@RequestMapping(value="/duomeis/student")
	public void getStudent(HttpServletRequest request,HttpServletResponse response) {
		    String student_id="123456";
	        StudentEntity student=service.getStudentinfo(student_id);
	        System.out.println(student.getStudent_id()+ "  " +student.getStudent_name());
		    System.out.println("asdbhsdgfgusdlgfuyzlf");
	}

}
