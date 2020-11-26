package com.wellsfargo.batch7.sbwdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.sbwdd.entity.AddressGroupEntity;
import com.wellsfargo.batch7.sbwdd.entity.ContactEntity;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Long>{

	List<ContactEntity> findAllByAdbGroup(AddressGroupEntity adbGroup);

}
