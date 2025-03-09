package com.product.papp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.papp.model.MessageResponse;
import com.product.papp.model.Product;
import com.product.papp.services.ProductService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		super();
	}
	

	//build create product Rest Api
	//http://localhost:8080/api/products
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
			
	}
		
	// build get all products REST API
	//http://localhost:8080/api/products
	@GetMapping
	public List<Product> getAllproducts(){
		return productService.getAllProducts();
	}
	
	// build get product by pid REST API
	// http://localhost:8080/api/products/1
	@GetMapping("{pid}")
	public ResponseEntity<Product> getproductById(@PathVariable("pid") long productId){
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	// build update product REST API
	// http://localhost:8080/api/products/1
	@PutMapping("{pid}")
	public ResponseEntity<Product> updateproduct(@PathVariable("pid") long pid , @RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, pid), HttpStatus.OK);
	}
	/*
	// build delete product REST API
	// http://localhost:8082/api/products/1
	@DeleteMapping("/{pid}")
	public ResponseEntity<MessageResponse> deleteProduct(@PathVariable("pid") long productId) {
	    // Get the response message from the service layer
	    MessageResponse response = productService.deleteProduct(productId);

	    // If the message indicates the product can't be deleted, return a 403 Forbidden status
	    if (response.getMessage().contains("can't delete")) {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	    }

	    // If the product was deleted successfully, return a 200 OK status
	    return ResponseEntity.ok(response);
	}
	*/
	 @DeleteMapping("/{pid}")
	    public ResponseEntity<Boolean> deleteProduct(@PathVariable("pid") Long pid) {
	        boolean isInUse = productService.deleteProduct(pid);
	        return ResponseEntity.ok(isInUse);
	    }
	
	
	
	
	
}