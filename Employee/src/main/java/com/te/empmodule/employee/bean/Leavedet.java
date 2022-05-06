package com.te.empmodule.employee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Leavedet{

	

	

	
	

	@Id
	@Column(name = "leave_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;

	@Column(name = "leave_date")
	private String date;

	@Column(name = "leave_status")
	private String leaveStatus = "Approved";

	@Column(name = "employee_id")
	private int employeeId;

}