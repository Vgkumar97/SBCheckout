package com.online.store.checkout.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/*
 * Entity to represent a {@link CART}.
 */
@Entity
@Table(name="CART")
public class Cart {
	@Id
	@Column(name="Name", nullable=false)
	String name;
	
	@Column(name="Quantity", nullable=false)
	long quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
