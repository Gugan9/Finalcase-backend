package com.te.empmodule.employee.bean;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Empdetail")
public class Empdetails {
	
	@Id
	@Column(name = "emp_id")
	private int Employee_ID;
	private String EmployeeName;
	private String EmployeeType;
	private String Email;
	private String Password;
	@Override
	public String toString() {
		return "Empdetails [Employee_ID=" + Employee_ID + ", EmployeeName=" + EmployeeName + ", EmployeeType="
				+ EmployeeType + ", Email=" + Email + ", Password=" + Password + "]";
	}
	
}
