package com.wellsfargo.batch7.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.batch7.sbwdd.entity.AdbEmployeeEntity;
import com.wellsfargo.batch7.sbwdd.entity.AdbUserEntity;

public interface AdbEmployeeRepo extends JpaRepository<AdbEmployeeEntity, Integer>{
	boolean existsByUserName(String userName);
	AdbEmployeeEntity findByUserName(String userName);
}
