package com.wellsfargo.batch7.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.batch7.sbwdd.entity.AdbSubscriberEntity;

public interface AdbSubscriberRepo extends JpaRepository<AdbSubscriberEntity, Integer>{
	boolean existsByUserName(String userName);
	AdbSubscriberEntity findByUserName(String userName);
}

