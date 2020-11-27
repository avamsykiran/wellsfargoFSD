package com.wellsfargo.batch7.sbwdd.util;

import com.wellsfargo.batch7.sbwdd.entity.AddressGroupEntity;
import com.wellsfargo.batch7.sbwdd.entity.ContactDetailsEntity;
import com.wellsfargo.batch7.sbwdd.entity.ContactEntity;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.model.ContactDetailsModel;
import com.wellsfargo.batch7.sbwdd.model.ContactModel;

public class EMParser {
	
	public static ContactDetailsModel parse(ContactDetailsEntity source) {
		ContactDetailsModel target = new ContactDetailsModel();
		target.setAddressLine1(source.getAddressLine1());
		target.setAddressLine2(source.getAddressLine2());
		target.setCity(source.getCity());
		target.setEmailId(source.getEmailId());
		target.setMobileNumber(source.getMobileNumber());
		target.setState(source.getState());
		return target;
	}
	
	public static ContactDetailsEntity parse(ContactDetailsModel source) {
		ContactDetailsEntity target = new ContactDetailsEntity();
		target.setAddressLine1(source.getAddressLine1());
		target.setAddressLine2(source.getAddressLine2());
		target.setCity(source.getCity());
		target.setEmailId(source.getEmailId());
		target.setMobileNumber(source.getMobileNumber());
		target.setState(source.getState());
		return target;
	}

	public static ContactModel parse(ContactEntity source) {
		ContactModel target = new ContactModel();
		target.setContactId(source.getContactId());
		target.setFirstName(source.getFirstName());
		target.setLastNAme(source.getLastNAme());
		target.setContactDetails(parse(source.getContactDetails()));
		target.setAdbGroup(parse(source.getAdbGroup()));		
		return target;
	}
	
	public static ContactEntity parse(ContactModel source) {
		ContactEntity target = new ContactEntity();
		target.setContactId(source.getContactId());
		target.setFirstName(source.getFirstName());
		target.setLastNAme(source.getLastNAme());
		target.setContactDetails(parse(source.getContactDetails()));
		target.setAdbGroup(parse(source.getAdbGroup()));		
		return target;
	}
	
	public static AddressGroupEntity parse(AddressGroupModel source) {
		AddressGroupEntity target = new AddressGroupEntity();
		target.setGroupId(source.getGroupId());
		target.setGroupTitle(source.getGroupTitle());
		return target;
	}
	
	public static AddressGroupModel parse(AddressGroupEntity source) {
		AddressGroupModel target = new AddressGroupModel();
		target.setGroupId(source.getGroupId());
		target.setGroupTitle(source.getGroupTitle());
		return target;
	}
}
