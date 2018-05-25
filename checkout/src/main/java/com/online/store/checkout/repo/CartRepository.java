package com.online.store.checkout.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.store.checkout.model.Cart;

/*
 * Repository interface to query Cart from the H2 database.
 */
@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
	/*
	 * Method to retrieve list of items for given name.
	 * 
	 * @param type
	 * @return list of products
	 */
	public List<Cart> findByNameLike(String name);
}