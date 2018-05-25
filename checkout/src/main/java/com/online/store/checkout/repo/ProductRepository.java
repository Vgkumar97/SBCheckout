package com.online.store.checkout.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.store.checkout.model.Product;

/*
 * Repository interface to query products from the H2 database.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	/*
	 * Method to retrieve list of products for given type.
	 * 
	 * @param type
	 * @return list of products
	 */
	public List<Product> findByTypeLike(String type);
}

