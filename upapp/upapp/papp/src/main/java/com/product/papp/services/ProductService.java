package com.product.papp.services;

import java.util.List;

import com.product.papp.model.MessageResponse;
import com.product.papp.model.Product;

public interface ProductService {
	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long pid);
	Product updateProduct(Product product, long pid);
	//MessageResponse deleteProduct(long pid);
	boolean deleteProduct(Long pid);

}
