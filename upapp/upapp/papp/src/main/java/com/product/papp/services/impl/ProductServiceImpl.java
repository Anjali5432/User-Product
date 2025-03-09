package com.product.papp.services.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.product.papp.exception.ResourceNotFoundException;
import com.product.papp.model.MessageResponse;
import com.product.papp.model.Product;
import com.product.papp.model.UserDTO;
import com.product.papp.repository.ProductRepository;
import com.product.papp.services.ProductService;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RestTemplate restTemplate; // Inject RestTemplate
	
	private static final String USER_SERVICE_URL = "http://localhost:8081/api/users"; // Adjust the URL as needed

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(long pid) {
		return productRepository.findById(pid).orElseThrow(() -> 
		              new ResourceNotFoundException("User not found with id :" + pid));
	}
	
	@Override	
	public Product updateProduct(Product product, long pid) {
		//we need to check whether product with given pid is present in DB or not
		Product existingProduct = productRepository.findById(pid).orElseThrow(
						() -> new ResourceNotFoundException("User not found with id :" + pid)); 
				
		existingProduct.setCreator(product.getCreator());
		existingProduct.setPrice(product.getPrice());
		//save existing product to DB
		productRepository.save(existingProduct);
			return existingProduct;
	}
	
	/*
	@Override
	public MessageResponse deleteProduct(long productId) {
	    // Check whether the product exists in the database
	    Product product = productRepository.findById(productId)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

	    // Check if the product is associated with any user
	    if (isProductUsedByUser (productId)) {
	        // If the product is used by a user, return the appropriate message
	        return new MessageResponse("You can't delete this product because it's already used by a user.");
	    }

	    // If no user is using the product, delete it
	    productRepository.deleteById(productId);
	    return new MessageResponse("Product deleted successfully.");
	}


	private boolean isProductUsedByUser (long productId) {
	    // Call the User service to check if any user is associated with the product
	    String url = USER_SERVICE_URL + "?pid=" + productId; // Assuming the user service can filter by pid
	    UserDTO[] users = restTemplate.getForObject(url, UserDTO[].class);

	    return users != null && users.length > 0; // Return true if any users are found
	}
	*/
	
	 public boolean deleteProduct(Long pid) {
	        // URL of the User Microservice
	        String userServiceUrl = "http://localhost:8081/api/users/product/" + pid;

	        // Check if the product is in use by any user
	        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(userServiceUrl, Boolean.class);
	        Boolean isProductInUse = responseEntity.getBody();

	        if (Boolean.TRUE.equals(isProductInUse)) {
	            // Return true if the product is in use
	            return true;
	        }

	        // Delete the product if not in use
	        productRepository.deleteById(pid);
	        // Return false if the product is successfully deleted
	        return false;
	    }
}