package com.wellsfargo.fsd.imsa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wellsfargo.fsd.imsa.dao.ItemRepository;
import com.wellsfargo.fsd.imsa.entity.Item;
import com.wellsfargo.fsd.imsa.exception.ImsException;
import com.wellsfargo.fsd.imsa.service.ItemService;

@SpringJUnitConfig
@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
public class ItemServiceIntegrationTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemService itemService;
	
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
			itemRepository.saveAndFlush(item);
		}
	}
	
	@AfterEach
	public void tearDown(){
		itemRepository.deleteAll();
		testData=null;
	}
	
	@Test
	public void whenAdd_givenNonExitingRecord_test() {
		Item item = new Item(106, "Urdh Dal", LocalDate.now(), true, "PACKET", 204.0, 524.0);
		
		try {
			assertEquals(itemService.add(item), item);
		} catch (ImsException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void whenAdd_givenExitingRecord_test() {
		Item item = testData.get(0);				
		assertThrows(ImsException.class, ()->{itemService.add(item);});
	}
	
	@Test
	public void whenGetItemById_givenExistingIcode_test() throws ImsException {
		Item item = testData.get(0);		
		
		assertSame(itemService.getItemById(item.getIcode()), item);	
	}
}
