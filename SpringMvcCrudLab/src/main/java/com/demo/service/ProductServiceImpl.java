package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;
@Service

public class ProductServiceImpl implements ProductService {
	@Autowired
	 private ProductDao pdao;
	@Override
	public List<Product> getAllProducts() {
		
		return pdao.findAllproducts();
	}
	@Override
	public void addnewproduct(Product p) {
		 pdao.save(p);
		
	}


	
}
