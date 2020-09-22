package com.wellsfargo.fsd.imsa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.imsa.entity.IMSUser;

@Repository
public interface IMSUserRepo extends JpaRepository<IMSUser, Integer>{

	IMSUser findByUserName(String userName);
}
