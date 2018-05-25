package com.online.store.checkout.rest;

import org.springframework.web.bind.annotation.*;

import com.online.store.checkout.model.Product;
import com.online.store.checkout.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * REST controller for Products.
 */
@RestController
@RequestMapping("/store/checkout/products")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	/*
	 * GET : get all the products.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list of all available products.
	 */
	@GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		
		if (products != null && products.size() > 0) {
			log.info("Products found.");
			
			return new ResponseEntity<>(products, HttpStatus.OK);
		} else {
			log.info("No products were found.");
			
			return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
		}
    }

	/*
	 * GET  /{type} get the list of type products.
	 * 
	 * @param type the type of the products to retrieve.
	 * @return the ResponseEntity with status 200 (OK) and the list of available products for the type, 
	 * or with status 404 (Not Found)
	 */
	@GetMapping("/{type}")
	public ResponseEntity<List<Product>> getProductsByType(@PathVariable("type") String type) {
		List<Product> products = productService.getProductsByType(type);
		
		if (products != null && products.size() > 0) {
			log.info("Products found for the type " + type);
			
			return new ResponseEntity<>(products, HttpStatus.OK);
		} else {
			log.info("No products were found for the type " + type);
			
			return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
		}
	}
}
