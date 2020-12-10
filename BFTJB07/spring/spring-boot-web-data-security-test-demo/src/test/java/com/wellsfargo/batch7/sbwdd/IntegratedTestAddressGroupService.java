package com.wellsfargo.batch7.sbwdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
public class IntegratedTestAddressGroupService {

	@Autowired
	private AddressGroupRepo agRepo;
	
	@Autowired
	private AddressGroupService agService;
	
	private AddressGroupModel[] testData;
	
	@BeforeEach
	void setUp(){
		testData = new AddressGroupModel[] {
				new AddressGroupModel(101, "Doctors"),
				new AddressGroupModel(102, "Lawyers")
		};
		for(AddressGroupModel agm:testData) {
			agRepo.saveAndFlush(EMParser.parse(agm));
		}
	}
	
	@AfterEach
	void cleanUp() {
		agRepo.deleteAll();
		agRepo.flush();
		testData=null;
	}

	@Test
	void testAdd() throws AddressBookException {
		AddressGroupModel model = new AddressGroupModel(103, "XYZ");
		AddressGroupModel actualData = agService.add(model);
		assertEquals(model.getGroupId(), actualData.getGroupId());
	}
	
	@Test
	void testAddExitingRecord() throws AddressBookException {
		AddressGroupModel model = testData[0];	
		assertThrows(AddressBookException.class, ()->{agService.add(model);});
	}
}
