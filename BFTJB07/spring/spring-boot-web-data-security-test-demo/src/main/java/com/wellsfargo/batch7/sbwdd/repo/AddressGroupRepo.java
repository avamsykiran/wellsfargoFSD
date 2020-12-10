package com.wellsfargo.batch7.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch7.sbwdd.entity.AddressGroupEntity;

@Repository
public interface AddressGroupRepo extends JpaRepository<AddressGroupEntity, Integer>{

}
