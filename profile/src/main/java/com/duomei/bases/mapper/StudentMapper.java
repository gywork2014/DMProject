package com.duomei.bases.mapper;

import com.duomei.bases.entity.StudentEntity;

public interface StudentMapper extends SqlMapper {
	public StudentEntity getStudent(String student_id);
}
