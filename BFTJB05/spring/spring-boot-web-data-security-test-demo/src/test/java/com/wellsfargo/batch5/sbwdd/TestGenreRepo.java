package com.wellsfargo.batch5.sbwdd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.wellsfargo.batch5.sbwdd.entity.GenreEntity;
import com.wellsfargo.batch5.sbwdd.repo.GenreRepo;

/*it is going to config h2 database, execute schema or create 
 * table in it and supplies testentitymanager
 */
@DataJpaTest 
public class TestGenreRepo {

	@Autowired
	private TestEntityManager entityManager; // used to verify the effects on db 
	
	@Autowired
	private GenreRepo genreRepo;  // to be tested
	
	private GenreEntity[] testData;
	
	@BeforeEach
	void beforeEachTest() {
		testData = new GenreEntity[] {
				new GenreEntity(101, "Fiction"),
				new GenreEntity(102, "Science"),
				new GenreEntity(103, "Computers")
		};
		
		for(GenreEntity ge : testData) {
			entityManager.persistAndFlush(ge);
		}
	}
	
	@AfterEach
	void afterEachTest() {
		for(GenreEntity ge : testData) {
			entityManager.remove(ge);
		}
		entityManager.flush();
	}
	
	@Test
	void testFindAll() {
		List<GenreEntity> genresList = genreRepo.findAll();
		GenreEntity[] actualData = genresList.toArray(new GenreEntity[] {});
		assertArrayEquals(actualData, testData);
	}

	@Test
	void testFindByIdGivenExistingId() {
		GenreEntity actualData = genreRepo.findById(testData[0].getGenreId()).get();
		assertEquals(actualData, testData[0]);
	}
	
	@Test
	void testFindByIdGivenNonExistingId() {
		GenreEntity actualData = genreRepo.findById(Integer.MAX_VALUE).orElse(null);
		assertNull(actualData);
	}
}
