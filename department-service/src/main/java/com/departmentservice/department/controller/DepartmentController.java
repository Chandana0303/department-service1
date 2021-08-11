package com.departmentservice.department.controller;

import java.util.List;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.departmentservice.department.exception.ResourceNotFound;
import com.departmentservice.department.model.Department;
import com.departmentservice.department.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments()
	{
		List<Department> departments = departmentRepository.findAll();
		if(departments.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(departments);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") String id) throws ResourceNotFound
	{
		
		Department department = departmentRepository.findById(id).orElseThrow(()->new ResourceNotFound("department not found::"+id));
		return ResponseEntity.ok().body(department);
		/*Optional<Department> optional= departmentRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
		}*/
		
	}
	
	@PostMapping("/createDepartment")
	public ResponseEntity<?> createDepartment(@Valid @RequestBody Department department)

	{	
			if(departmentRepository.existsById(department.getDeptId()))
			{
				return ResponseEntity.status(HttpStatus.CONFLICT).body("record already exists");
			}
			Department dept1 = departmentRepository.save(department);
			System.out.println(dept1);
			if(dept1!=null)
			{
			return ResponseEntity.status(HttpStatus.CREATED).body(dept1);
		
	}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Data not created");
			}
}
}