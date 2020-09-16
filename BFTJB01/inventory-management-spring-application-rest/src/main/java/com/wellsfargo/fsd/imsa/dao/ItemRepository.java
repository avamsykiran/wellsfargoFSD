package com.wellsfargo.fsd.imsa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.imsa.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	Item findByTitle(String title);
	List<Item> findAllByUnit(String unit);
	
	@Query("SELECT i FROM Item i WHERE i.sellingPrice BETWEEN :lower AND :upper")
	List<Item> findAllInSellingPriceRange(double lower,double upper);
}
