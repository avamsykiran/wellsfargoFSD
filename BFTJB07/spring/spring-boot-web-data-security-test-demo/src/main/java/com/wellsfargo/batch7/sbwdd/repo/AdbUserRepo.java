package com.wellsfargo.batch7.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.batch7.sbwdd.entity.AdbUserEntity;

public interface AdbUserRepo extends JpaRepository<AdbUserEntity, Integer>{
	boolean existsByUserName(String userName);
	AdbUserEntity findByUserName(String userName);
}
