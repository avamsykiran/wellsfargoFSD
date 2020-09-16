package com.wellsfargo.fsd.cms.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.cms.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

	boolean existsByMobile(String mobile);
	
	Contact findByMobile(String mobile);
	
	List<Contact> findAllByGroup(String group);
	
	@Query("SELECT c FROM Contact c WHERE c.dateOfBirth BETWEEN :start and :end")
	List<Contact> findAllBornInRange(@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE) LocalDate end);
}
