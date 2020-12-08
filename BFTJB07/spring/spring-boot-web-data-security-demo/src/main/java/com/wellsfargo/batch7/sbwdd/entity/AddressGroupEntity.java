package com.wellsfargo.batch7.sbwdd.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="address_groups")
public class AddressGroupEntity {
	
	@Id
	@Column(name="grp_id")
	private Integer groupId;
	
	@Column(name="grp_title",nullable=false,unique=true)
	private String groupTitle;
	
	@OneToMany(mappedBy="adbGroup",cascade=CascadeType.ALL)
	private Set<ContactEntity> contacts;

	public AddressGroupEntity() {
		
	}
	
	public AddressGroupEntity(Integer groupId, String groupTitle) {
		super();
		this.groupId = groupId;
		this.groupTitle = groupTitle;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public Set<ContactEntity> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactEntity> contacts) {
		this.contacts = contacts;
	}
	
	
}
