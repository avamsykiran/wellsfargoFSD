package com.wellsfargo.fsd.imsa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import com.wellsfargo.fsd.imsa.dao.ItemRepository;
import com.wellsfargo.fsd.imsa.entity.Item;

@DataJpaTest
public class ItemRepoTest {

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private List<Item> testData;
	
	@BeforeEach
	public void setUp(){
		testData = Arrays.asList(new Item[] {
				new Item(101, "Rice Bag", LocalDate.now(), true, "BAG", 1024.0, 2024.0),
				new Item(102, "Sugar Bag", LocalDate.now(), true, "BAG", 3024.0, 4024.0),
				new Item(103, "Channa Dal", LocalDate.now(), true, "PACKET", 1024.0, 2024.0),
				new Item(104, "Wheat Bag", LocalDate.now(), true, "BAG", 5024.0, 7024.0),
				new Item(105, "Urdh Dal", LocalDate.now(), true, "PACKET", 204.0, 524.0)
		});
		
		for(Item item : testData) {			
			entityManager.persistAndFlush(item);
		}
	}
	
	@AfterEach
	public void tearDown(){
		entityManager.clear();
		entityManager.flush();
		testData=null;
	}
	
	@Test
	public void whenFndByTitle_GivenExisitngTitle_test() {
		Item expected = testData.get(0);
		Item actual = itemRepo.findByTitle(expected.getTitle());
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenFndByTitle_GivenNonExisitngTitle_test() {		
		Item actual = itemRepo.findByTitle("abcdefghijklmn");
		assertNull(actual);
	}
}
