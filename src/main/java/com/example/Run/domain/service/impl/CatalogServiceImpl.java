package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Catalog;
import com.example.Run.domain.repository.CatalogRepository;
import com.example.Run.domain.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	private CatalogRepository catalogRepository;
	@Override
	public List<Catalog> getAllCatalog() {
		// TODO Auto-generated method stub
		return catalogRepository.findAll();
	}

	@Override
	public Catalog createCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogRepository.save(catalog);
	}

	@Override
	public Catalog Update(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogRepository.save(catalog);
	}

	@Override
	public void deleteCatalogById(long id) {
		// TODO Auto-generated method stub
		catalogRepository.deleteById(id);
	}

	@Override
	public Optional<Catalog> findById(long id) {
		// TODO Auto-generated method stub
		return catalogRepository.findById(id);
	}

	@Override
	public List<Catalog> findCatalog(long id) {
		// TODO Auto-generated method stub
		return catalogRepository.findId(id);
	}
	
	@Override
	public List<String> findCatalogImage(long id) {
		// TODO Auto-generated method stub
		return catalogRepository.findImage(id);
	}

}
