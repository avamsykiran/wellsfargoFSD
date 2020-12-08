package com.wellsfargo.batch5.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.sbwdd.entity.LibraryUser;

@Repository
public interface LibraryUserRepo extends JpaRepository<LibraryUser,Integer>{
	boolean existsByUserName(String userName);
	LibraryUser findByUserName(String userName);
}
