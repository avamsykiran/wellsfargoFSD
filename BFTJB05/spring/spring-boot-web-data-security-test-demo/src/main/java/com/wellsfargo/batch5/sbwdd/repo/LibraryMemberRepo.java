package com.wellsfargo.batch5.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.sbwdd.entity.Librarian;
import com.wellsfargo.batch5.sbwdd.entity.LibraryMember;

@Repository
public interface LibraryMemberRepo extends JpaRepository<LibraryMember,Integer>{
	boolean existsByUserName(String userName);
	LibraryMember findByUserName(String userName);
}
