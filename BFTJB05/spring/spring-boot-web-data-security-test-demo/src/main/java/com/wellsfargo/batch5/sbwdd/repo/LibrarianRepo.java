package com.wellsfargo.batch5.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.sbwdd.entity.Librarian;

@Repository
public interface LibrarianRepo extends JpaRepository<Librarian,Integer>{
	boolean existsByUserName(String userName);
	Librarian findByUserName(String userName);
}
