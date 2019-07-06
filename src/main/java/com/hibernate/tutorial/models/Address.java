package com.hibernate.tutorial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_address")
public class Address {
	@Id
	@Column(name = "address_id")
	private long id;

	@Column(nullable = false)
	private String address;

	@Column(nullable = true)
	private String location;

	@Column(nullable = false)
	private String country;

	@Column(nullable = true)
	private String province;

	@OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
	private Employee employee;

	public Address() {
	}

	public Address(Long id, String address, String location, String country, String province) {
		this.id = id;
		this.address = address;
		this.location = location;
		this.country = country;
		this.province = province;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", location=" + location + ", country=" + country
				+ ", province=" + province + ", employee=" + employee + "]";
	}

}
