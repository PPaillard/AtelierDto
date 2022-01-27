package com.wcs.dtouser.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryDto {
	private Long id;
	
	@NotBlank
	@Size(min = 2, max =100)
	private String name;
	
	private List<ProductWithMustHaveDto> productWithMustHaveDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductWithMustHaveDto> getProductWithMustHaveDto() {
		return productWithMustHaveDto;
	}

	public void setProductWithMustHaveDto(List<ProductWithMustHaveDto> productWithMustHaveDto) {
		this.productWithMustHaveDto = productWithMustHaveDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
