package com.wcs.dtouser.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.dtouser.dto.CategoryDto;
import com.wcs.dtouser.entity.Category;
import com.wcs.dtouser.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping
	public Category create(@Valid @RequestBody CategoryDto categoryDto) {
		return categoryRepository.save(new Category(categoryDto.getName()));
	}
}
