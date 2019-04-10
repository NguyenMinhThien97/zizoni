package com.example.Run.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Run.domain.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value ="SELECT p FROM Product p WHERE p.catalogID = :catalogID ") 
	List<Product> ProductsByCatalog(@Param("catalogID")int catalogID);
	
	@Query(value ="SELECT * FROM Product ORDER BY view DESC LIMIT 10" , nativeQuery = true)
	List<Product> FeaturedProducts();
	
	@Query(value ="SELECT * FROM Product WHERE catalogID  = :catalogID ORDER BY view DESC LIMIT 10 ", nativeQuery = true) 
	List<Product> RelatedProducts(@Param("catalogID")int catalogID);
	
	@Query(value ="SELECT c.name,c.id FROM Product c")
	List<Product> getNameProducts();
	
}
