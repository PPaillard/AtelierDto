package com.wcs.dtouser.dto;

public class ProductWithMustHaveDto {
	
	private Long id;
	
	private String name;
	
	private Float price;
	
	private boolean mustHave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean isMustHave() {
		return mustHave;
	}

	public void setMustHave(boolean mustHave) {
		this.mustHave = mustHave;
	}
}
