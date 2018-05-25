package com.online.store.checkout.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/*
 * Entity to represent a {@link PRODUCT}.
 */
@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@Column(name="Id", nullable=false)
	long id;
	
	@Column(name="Type", nullable=false)
	String type;
	
	@Column(name="Name", nullable=false)
	String name;
	
	@Column(name="Description", nullable=false)
	String description;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

