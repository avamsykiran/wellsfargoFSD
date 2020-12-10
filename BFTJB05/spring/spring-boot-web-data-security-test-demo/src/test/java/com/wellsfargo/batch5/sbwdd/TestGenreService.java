package com.wellsfargo.batch5.sbwdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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

import com.wellsfargo.batch5.sbwdd.entity.GenreEntity;
import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;
import com.wellsfargo.batch5.sbwdd.repo.GenreRepo;
import com.wellsfargo.batch5.sbwdd.service.GenreService;
import com.wellsfargo.batch5.sbwdd.service.GenreServiceImpl;
import com.wellsfargo.batch5.sbwdd.util.EMParser;

@SpringJUnitConfig
public class TestGenreService {

	@MockBean
	private GenreRepo genreRepo;
	
	@Autowired
	private GenreService genreService;
	
	@TestConfiguration
	public static class MyTemporaryConfig{
		@Bean
		public GenreService genreService() {
			return new GenreServiceImpl();
		}
	}
	
	private GenreModel[] testData;
	
	@BeforeEach
	void doBeforeEachTest() {
		testData = new GenreModel[] {
				new GenreModel(101,"Fiction"),
				new GenreModel(102,"Computers")
		};
	}
	
	@AfterEach
	void cleanUp() {
		testData=null;
	}
	
	@Test
	void tetAddNonExisitngRecord() throws LibraryException {
		GenreModel model = new GenreModel(103,"XYZ");
		GenreEntity entity = EMParser.parse(model);
		
		Mockito.when(genreRepo.existsById(model.getGenreId())).thenReturn(false);
		Mockito.when(genreRepo.save(Mockito.any())).thenReturn(entity);
		
		assertEquals(model.getGenreId(), genreService.add(model).getGenreId());
		
	}
	
	@Test
	void tetAddExisitngRecord() throws LibraryException {
		GenreModel model = testData[0];
		
		Mockito.when(genreRepo.existsById(model.getGenreId())).thenReturn(true);
		
		assertThrows(LibraryException.class, 
				()->{genreService.add(model);});
	}
}
