package com.example.Run.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Run.domain.entity.Product;
import com.example.Run.domain.service.ProductService;


@Service
@RestController
@RequestMapping("product")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService productService;

	
	@GetMapping("/listProduct")
	public ResponseEntity<List<Product>>  getAllProduct(){
		List<Product> list = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Product>>  getProduct(){
		List<Product> list = productService.getNameProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	@GetMapping("/listProduct/{id}")
	public Optional<Product> getProductByID(@PathVariable("id") long id){
		return productService.findById(id);
	}
	
	@GetMapping("/listProductsByCatalog/{catalogID}")
	public ResponseEntity<List<Product>>  getProductsByCatalog(@PathVariable("catalogID") int catalogID){
		List<Product> list = productService.getProductsByCatalog(catalogID);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listRelatedProducts/{catalogID}")
	public ResponseEntity<List<Product>>  getRelatedProduct(@PathVariable("catalogID") int catalogID){
		List<Product> list = productService.getRelatedProducts(catalogID);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/listFeaturedProducts")
	public ResponseEntity<List<Product>>  getFeaturedProducts(){
		List<Product> list = productService.getFeaturedProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder){
		List<Product> listProducts = productService.getAllProduct();
		for( Product products : listProducts)
			if(product.getName().equals(products.getName())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				productService.createProduct(product);
			} 
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/Product/{id,name,price}").buildAndExpand(product.getId(),product.getName(),product.getPrice()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody Product product){
		Optional<Product> listProduct = productService.findById(product.getId());
		if (!listProduct.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			productService.Update(product);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<Product> delete(@PathVariable("id") long id){
		Optional<Product> listProduct = productService.findById(id);
		if (!listProduct.isPresent()) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		else 
			productService.deleteProductById(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
}
