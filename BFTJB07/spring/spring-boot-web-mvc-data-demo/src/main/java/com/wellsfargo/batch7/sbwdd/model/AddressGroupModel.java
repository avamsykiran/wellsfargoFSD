package com.wellsfargo.batch7.sbwdd.model;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressGroupModel {

	@NotNull(message="Group Id is mandatory")
	private Integer groupId;
	
	@NotNull(message="Group Title is mandatory")
	@NotBlank(message="Group Title can not be null")
	@Size(min=4,max=50,message="Group Title must be 4 to 50 chars in length")
	private String groupTitle;
	
	public AddressGroupModel() {
		
	}
	
	public AddressGroupModel(Integer groupId, String groupTitle) {
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
	
}
