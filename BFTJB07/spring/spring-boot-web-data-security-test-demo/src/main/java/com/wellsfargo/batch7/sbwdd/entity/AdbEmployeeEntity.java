package com.wellsfargo.batch7.sbwdd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adb_emps")
public class AdbEmployeeEntity extends AdbUserEntity {

	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_basic")
	private Double basic;
	

	public AdbEmployeeEntity() {
		
	}

	public AdbEmployeeEntity(Integer userId, String userName, String password, String role,String name,Double basic) {
		super(userId, userName, password, role);
		this.name=name;
		this.basic=basic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	
	
	
}
