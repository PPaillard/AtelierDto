package com.wcs.dtouser.dto;

import javax.validation.constraints.NotNull;

public class CategoryMustHaveDto {

	@NotNull
	private Long id;
	
	private boolean mustHave;

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
}
