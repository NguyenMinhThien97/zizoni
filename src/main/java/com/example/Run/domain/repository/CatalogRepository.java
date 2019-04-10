package com.example.Run.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Run.domain.entity.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository< Catalog, Long>{
	@Query(value ="SELECT c FROM Catalog c WHERE c.id = :id") 
	List<Catalog> findId(@Param("id")long id);
	@Query(value ="SELECT DISTINCT(c.image) FROM Catalog c WHERE c.id = :id") 
	List<String> findImage(@Param("id")long id);
}
