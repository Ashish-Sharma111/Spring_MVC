package com.demo.service;
import java.util.List;

import com.demo.model.Product;


public interface ProductService {

	List<Product> getAllProducts();
	
	void addnewproduct (Product p);
}
