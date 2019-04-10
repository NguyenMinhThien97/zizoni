package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;


import com.example.Run.domain.entity.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public Product createProduct(Product product);
	public Product Update(Product product);
	public void deleteProductById(long id);
	public Optional<Product> findById(long id);
	public List<Product> getProductsByCatalog(int catalogID );
	public List<Product> getFeaturedProducts();
	public List<Product> getRelatedProducts(int catalogID );
	public List<Product> getNameProducts();
}
