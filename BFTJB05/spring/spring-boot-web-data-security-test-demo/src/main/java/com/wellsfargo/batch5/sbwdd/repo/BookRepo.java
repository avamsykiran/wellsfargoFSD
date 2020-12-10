package com.wellsfargo.batch5.sbwdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.sbwdd.entity.BookEntity;
import com.wellsfargo.batch5.sbwdd.entity.GenreEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

	List<BookEntity> findAllByGenere(GenreEntity Genere);
}
