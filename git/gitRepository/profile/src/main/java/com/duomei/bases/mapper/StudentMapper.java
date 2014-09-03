package com.duomei.bases.mapper;

import org.apache.ibatis.annotations.Param;

import com.duomei.bases.entity.StudentEntity;

public interface StudentMapper extends SqlMapper {
	public StudentEntity getStudent(@Param("student_id") String student_id);
}
