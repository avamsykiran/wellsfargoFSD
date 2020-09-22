package com.wellsfargo.fsd.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.lms.entity.LMSUser;

@Repository
public interface LMSUserRepo extends JpaRepository<LMSUser, Integer>{
	boolean existsByUserName(String userName);
	LMSUser findByUserName(String userName);
}
