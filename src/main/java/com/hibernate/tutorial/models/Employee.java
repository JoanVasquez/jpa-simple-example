package com.hibernate.tutorial.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employee_id", nullable = false)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String fName;

	@Column(name = "last_name", nullable = false)
	private String lName;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	public Employee() {
	}

	public Employee(Long id, String fName, String lName, LocalDate birthDate) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Employee [code=" + id + ", fName=" + fName + ", lName=" + lName + ", birthDate=" + birthDate + "]";
	}

}
