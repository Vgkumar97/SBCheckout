package com.online.store.checkout.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.store.checkout.model.Product;
import com.online.store.checkout.repo.ProductRepository;

/*
 * Service class to read the products from ProductRepository.
 */
@Component
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/*
	 * This method returns all the available products from PRODUCT table.
	 * 
	 * @param 
	 * @return list of products
	 */
    public List<Product> getAllProducts() {
		return StreamSupport.stream(productRepository.findAll().spliterator(), false)
														.collect(Collectors.toList());
    }

	/*
	 * This method returns list of products for given type from PRODUCT table.
	 * 
	 * @param type
	 * @return list of products 
	 */
    public List<Product> getProductsByType(String type) {
		return StreamSupport.stream(productRepository.findByTypeLike(type).spliterator(), false)
														.collect(Collectors.toList());
    }	
}
