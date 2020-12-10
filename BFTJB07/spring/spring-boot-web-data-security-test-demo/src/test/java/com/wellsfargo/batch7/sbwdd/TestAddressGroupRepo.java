package com.wellsfargo.batch7.sbwdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.wellsfargo.batch7.sbwdd.entity.AddressGroupEntity;
import com.wellsfargo.batch7.sbwdd.repo.AddressGroupRepo;

@DataJpaTest
public class TestAddressGroupRepo {

	@Autowired
	private AddressGroupRepo agRepo;
	
	@Autowired
	private TestEntityManager em;
	
	private AddressGroupEntity[] testData;
	
	@BeforeEach
	void doBeforeEachTest() {
		testData = new AddressGroupEntity[] {
				new AddressGroupEntity(101, "Doctors"),
				new AddressGroupEntity(102, "Lawyers"),
				new AddressGroupEntity(103, "Physitherepoists"),
		};
		for(AddressGroupEntity g :testData) {
			em.persistAndFlush(g);
		}
	}
	
	@AfterEach
	void cleanup() {
		for(AddressGroupEntity g :testData) {
			em.remove(g);
		}
		em.flush();
	}
	
	@Test
	void testFindAll() {
		AddressGroupEntity[] actualData = agRepo.findAll().toArray(new AddressGroupEntity[] {});
		assertArrayEquals(testData, actualData);
	}
}
