package com.wellsfargo.fsd.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.cms.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
