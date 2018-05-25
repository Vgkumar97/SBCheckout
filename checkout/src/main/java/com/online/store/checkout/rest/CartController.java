package com.online.store.checkout.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.checkout.model.Cart;
import com.online.store.checkout.repo.CartRepository;
import com.online.store.checkout.service.CartService;

/*
 * REST controller for Cart.
 */
@RestController
@RequestMapping("/store/checkout/cart")
public class CartController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cardService;

	/*
	 * GET : get all the items.
	 *
	 * @return the ResponseEntity with status 200 (OK) and the list of all items in the cart.
	 */
	@GetMapping
    public ResponseEntity<List<Cart>> getAllItems() {
		List<Cart> items = cardService.getAllItems();
		
		if (items != null && items.size() > 0) {
			return new ResponseEntity<>(items, HttpStatus.OK);
		} else {
			log.info("No items were found.");
			
			return new ResponseEntity<>(items, HttpStatus.NOT_FOUND);
		}
    }

	/*
	 * GET  /{name} get the item for the product name.
	 * 
	 * @param name the name of the product.
	 * @return the ResponseEntity with status 200 (OK) and the item for the product name, 
	 * or with status 404 (Not Found)
	 */
	@GetMapping("/{name}")
    public ResponseEntity<List<Cart>> getItem(@PathVariable("name") String name) {
		List<Cart> items = cardService.getItem(name);
		
		if (items != null && items.size() > 0) {
			return new ResponseEntity<>(items, HttpStatus.OK);
		} else {
			log.info("No items were found.");
			
			return new ResponseEntity<>(items, HttpStatus.NOT_FOUND);
		}
    }
	
	/*
	 * POST  /{name}/{quantity} add the item into the cart.
	 * 
	 * @param name the name of the product.
	 * @param quantity number of product.
	 * @return
	 */
	@PostMapping("/{name}/{quantity}")
	public void addItem(@PathVariable("name") String name, 
						@PathVariable("quantity") long quantity) throws Exception {
		cardService.addItem(name, quantity);
	}

	/*
	 * PUT  /{name}/{quantity} update the item in the cart.
	 * 
	 * @param name the name of the product.
	 * @param quantity number of product.
	 * @return 
	 */
	@PutMapping("/{name}/{quantity}")
	public void updateItem(@PathVariable("name") String name,
						   @PathVariable("quantity") long quantity) throws Exception {
		cardService.updateItem(name, quantity);
	}

	/*
	 * DELETE  /{name} delete the item from the cart.
	 * 
	 * @param name the name of the product.
	 * @return 
	 */
	@DeleteMapping("/{name}")
	public void deleteItem(@PathVariable("name") String name) throws Exception {
		cardService.deleteItem(name);
	}
}
