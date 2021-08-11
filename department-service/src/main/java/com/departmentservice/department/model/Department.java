package com.departmentservice.department.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "dept")
public class Department {
	
	@Id
	private String deptId;
	@Size(min=2,max=15,message="deptName shoud contain min 2 chars")
	private String deptName;
	@Size(min=2,max=15,message="deptLoc shoud contain min 2 chars")
	private String deptLoc;
	//@Positive()
	//private Long deptSalary;

}


