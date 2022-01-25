package com.wcs.dtouser.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean mustHave;
	
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name ="category_id", nullable = false)
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isMustHave() {
		return mustHave;
	}

	public void setMustHave(boolean mustHave) {
		this.mustHave = mustHave;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
