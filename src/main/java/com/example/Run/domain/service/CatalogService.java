package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.example.Run.domain.entity.Catalog;


public interface CatalogService {
	public List<Catalog> getAllCatalog();
	public Catalog createCatalog(Catalog catalog);
	public Catalog Update(Catalog catalog);
	public void deleteCatalogById(long id);
	public Optional<Catalog> findById(long id);
	public List<Catalog> findCatalog(@Param("id") long id);
	public List<String> findCatalogImage(@Param("id") long id);
}
