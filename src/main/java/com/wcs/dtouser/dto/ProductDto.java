package com.wcs.dtouser.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {

	@NotBlank
	@Size(min = 2, max = 100)
	private String name;
	
	private float price;
	
	@NotNull
	@Size(min = 1)
	// DTO permettant de capture le couple idCategory/mustHave que l'on envoit avec la création du produit.
	private List<CategoryMustHaveDto> categories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<CategoryMustHaveDto> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryMustHaveDto> categories) {
		this.categories = categories;
	}
}
