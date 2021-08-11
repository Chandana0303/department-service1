package com.departmentservice.department;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.departmentservice.department.model.Department;
import com.departmentservice.department.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context = SpringApplication.run(DepartmentServiceApplication.class, args);
	 DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class); 
	 //Department department = new Department("d003","BPO","Mumbai");
	 //List<Department> departments = departmentRepository.findAll();
	 //departments.forEach(System.out::println);
	 //departmentRepository.save(department);
	 //context.close();
	
	}

}
