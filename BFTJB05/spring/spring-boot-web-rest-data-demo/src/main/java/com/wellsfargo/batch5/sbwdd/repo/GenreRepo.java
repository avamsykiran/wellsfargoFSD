package com.wellsfargo.batch5.sbwdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.batch5.sbwdd.entity.GenreEntity;

@Repository
public interface GenreRepo extends JpaRepository<GenreEntity, Integer>{

}
