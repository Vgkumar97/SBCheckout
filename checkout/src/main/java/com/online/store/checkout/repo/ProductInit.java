package com.online.store.checkout.repo;

import org.springframework.boot.ApplicationRunner;

import com.online.store.checkout.model.Product;

import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Class to initialize the PRODUCT table if the table is empty.
 */
@Component
public class ProductInit implements ApplicationRunner {

	private ProductRepository productRepo;
	
	@Autowired
	public ProductInit(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public void run (ApplicationArguments args) throws Exception {
		long productCount = productRepo.count();
		
		if (productCount == 0) {
			Product p1 = new Product();
			
			p1.setId(01);
			p1.setType("Type 01");
			p1.setName("Product 01");
			p1.setDescription("Product 01");
			
			productRepo.save(p1);
			
			Product p2 = new Product();
			
			p2.setId(02);
			p2.setType("Type 01");
			p2.setName("Product 02");
			p2.setDescription("Product 02");
			
			productRepo.save(p2);			
		}
	}
}
