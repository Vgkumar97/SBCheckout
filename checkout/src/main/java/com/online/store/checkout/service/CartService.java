package com.online.store.checkout.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.online.store.checkout.model.Cart;
import com.online.store.checkout.repo.CartRepository;

/*
 * This service class will be used to perform CRUD operation on CART table.
 */
@Component
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	/*
	 * Method to read all the items form the cart.
	 * 
	 * @param 
	 * @return list of items.
	 */
    public List<Cart> getAllItems() {
		return StreamSupport.stream(cartRepository.findAll().spliterator(), false)
														.collect(Collectors.toList());
    }

	/*
	 * Method to read list of items for given product form the cart.
	 * 
	 * @param name
	 * @return list of items.
	 */
    public List<Cart> getItem(String name) {
		return StreamSupport.stream(cartRepository.findByNameLike(name).spliterator(), false)
														.collect(Collectors.toList());
    }
	
	/*
	 * Method to add item into the cart.
	 * 
	 * @param name
	 * @param quantity
	 * @return
	 */    
	public void addItem(String name, 
						long quantity) throws Exception {
		if (quantity <= 0) {
			throw new Exception("Invalid quantity.");
		} else {
			Cart cart = new Cart();
			cart.setName(name);
			cart.setQuantity(quantity);
			
			cartRepository.save(cart);
		}
	}
	
	/*
	 * Method to update the item in the cart.
	 * 
	 * @param name
	 * @param quantity
	 * @return
	 */  
	public void updateItem(@PathVariable("name") String name,
						   @PathVariable("quantity") long quantity) throws Exception {
		if (StreamSupport.stream(cartRepository.findByNameLike(name).spliterator(), false)
				.collect(Collectors.toList()).size() == 0) {
			throw new Exception("Item Not Found.");
		} else if (quantity <= 0) {
			throw new Exception("Invalid quantity.");
		} else {
			Cart cart = new Cart();
			cart.setName(name);
			cart.setQuantity(quantity);
			
			cartRepository.save(cart);
		}
	}
	
	/*
	 * Method to delete the item from the cart.
	 * 
	 * @param name
	 * @return
	 */  
	public void deleteItem(String name) throws Exception {
		if (StreamSupport.stream(cartRepository.findByNameLike(name).spliterator(), false)
				.collect(Collectors.toList()).size() == 0) {
			throw new Exception("Item Not Found.");
		} else {
			Cart cart = new Cart();
			cart.setName(name);
			
			cartRepository.delete(cart);
		}
	}	
}
