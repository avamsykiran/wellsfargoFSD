package com.wellsfargo.fsd.imsa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.imsa.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
