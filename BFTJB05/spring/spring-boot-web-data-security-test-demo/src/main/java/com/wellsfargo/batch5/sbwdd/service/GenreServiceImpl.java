package com.wellsfargo.batch5.sbwdd.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch5.sbwdd.entity.GenreEntity;
import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;
import com.wellsfargo.batch5.sbwdd.repo.GenreRepo;
import com.wellsfargo.batch5.sbwdd.util.EMParser;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreRepo genreRepo;

	@Transactional
	@Override
	public GenreModel add(GenreModel genre) throws LibraryException {
		if(genre!=null) {
			if(genreRepo.existsById(genre.getGenreId())) {
				throw new LibraryException("Genre# "+genre.getGenreId()+" already exits!");
			}
			genre = EMParser.parse(genreRepo.save(EMParser.parse(genre)));
		}
		return genre;
	}

	@Override
	public GenreModel get(int genreId) throws LibraryException {
		if(!genreRepo.existsById(genreId)) {
			throw new LibraryException("Genre# "+genreId+" does not exits!");
		}	
		return EMParser.parse(genreRepo.findById(genreId).get());
	}

	@Override
	public List<GenreModel> getAll() throws LibraryException {
		List<GenreEntity> entities = genreRepo.findAll();
		return entities.stream().map(e -> EMParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public void delete(int genreId) throws LibraryException {
		if(!genreRepo.existsById(genreId)) {
			throw new LibraryException("Genre# "+genreId+" does not exits!");
		}	
		genreRepo.deleteById(genreId);
	}

}
