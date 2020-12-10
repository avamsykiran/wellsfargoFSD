package com.wellsfargo.batch7.sbwdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.repo.AddressGroupRepo;
import com.wellsfargo.batch7.sbwdd.service.AddressGroupService;
import com.wellsfargo.batch7.sbwdd.service.AddressGroupServiceImpl;
import com.wellsfargo.batch7.sbwdd.util.EMParser;

@SpringJUnitConfig
public class StubTestAddressGroupService {

	@MockBean
	private AddressGroupRepo agRepo;
	
	@Autowired
	private AddressGroupService agService;
	
	@TestConfiguration
	public static class TestConfig{
		@Bean
		public AddressGroupService addressGroupService() {
			return new AddressGroupServiceImpl();
		}
	}
	
	private AddressGroupModel[] testData;
	
	@BeforeEach
	void setUp(){
		testData = new AddressGroupModel[] {
				new AddressGroupModel(101, "Doctors"),
				new AddressGroupModel(102, "Lawyers")
		};		
	}
	
	@AfterEach
	void cleanUp() {
		testData=null;
	}

	@Test
	void testAdd() throws AddressBookException {
		AddressGroupModel model = new AddressGroupModel(103, "XYZ");
		
		Mockito.when(agRepo.existsById(103)).thenReturn(false);
		Mockito.when(agRepo.save(Mockito.any())).thenReturn(EMParser.parse(model));
		
		AddressGroupModel actualData = agService.add(model);
		assertEquals(model.getGroupId(), actualData.getGroupId());
	}
	
	@Test
	void testAddExitingRecord() throws AddressBookException {
		AddressGroupModel model = testData[0];
		
		Mockito.when(agRepo.existsById(testData[0].getGroupId())).thenReturn(true);
		
		assertThrows(AddressBookException.class, ()->{agService.add(model);});
		
	}
}
