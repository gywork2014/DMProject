package com.duomei.test.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.duomei.bases.entity.StudentEntity;
import com.duomei.bases.mapper.StudentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-common.xml","classpath:applicationContext-beans.xml"})
public class MapperTest {
	
	@Autowired
	private StudentMapper studentmapper;
	
	@Test
	public void getStudentTest(){
		String stuid="123456";
		StudentEntity studententiy=studentmapper.getStudent(stuid);
		System.out.println(studententiy.getStudent_id()+"   "+studententiy.getStudent_name());
	}
}
