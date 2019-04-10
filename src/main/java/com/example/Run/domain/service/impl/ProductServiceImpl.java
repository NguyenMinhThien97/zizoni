package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Product;
import com.example.Run.domain.repository.ProductRepository;
import com.example.Run.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product Update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> getProductsByCatalog(int catalogID ) {
		// TODO Auto-generated method stub
		return productRepository.ProductsByCatalog(catalogID);
	}
	
	@Override
	public List<Product> getFeaturedProducts() {
		// TODO Auto-generated method stub
		return productRepository.FeaturedProducts();
	}
	@Override
	public List<Product> getRelatedProducts(int catalogID ) {
		// TODO Auto-generated method stub
		return productRepository.RelatedProducts(catalogID);
	}

	@Override
	public List<Product> getNameProducts() {
		// TODO Auto-generated method stub
		return productRepository.getNameProducts();
	}
}
