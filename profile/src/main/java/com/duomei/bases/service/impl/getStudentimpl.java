package com.duomei.bases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duomei.bases.entity.StudentEntity;
import com.duomei.bases.mapper.StudentMapper;
import com.duomei.bases.service.getStudentService;

@Service
public class getStudentimpl implements getStudentService{

    @Autowired
    private StudentMapper studentmapper;
    
	@Override
	public StudentEntity getStudentinfo(String student_id) {  
		return studentmapper.getStudent(student_id);
	}
}
