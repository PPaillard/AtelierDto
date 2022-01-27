package com.wcs.dtouser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.dtouser.dto.CategoryDto;
import com.wcs.dtouser.dto.ProductWithMustHaveDto;
import com.wcs.dtouser.entity.Category;
import com.wcs.dtouser.entity.ProductCategory;
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
	
	// On veut créer une méthode, qui, à pârtir de l'id categorie, va nous récuperer la categorie ainsi que ses produits assignés.
	@GetMapping("/{id}")
	public CategoryDto get(@PathVariable(required = true) Long id) {
		// On va chercher la categorie
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)) ;
		
		// je transforme ma category en categoryDto pour pouvoir y associé ma liste de productWithMustHaveDto
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		// j'initialise ma liste de productWithMustHaveDto
		List<ProductWithMustHaveDto> productsWithMustHaveDto = new ArrayList<>();
		
		// pour cette category, je recup toute les associations de produit de celle ci
		for(ProductCategory productCategory : category.getProductCategories()) {
			ProductWithMustHaveDto productWithMustHaveDto = new ProductWithMustHaveDto();
			productWithMustHaveDto.setId(productCategory.getProduct().getId());
			productWithMustHaveDto.setName(productCategory.getProduct().getName());
			productWithMustHaveDto.setPrice(productCategory.getProduct().getPrice());
			productWithMustHaveDto.setMustHave(productCategory.isMustHave());
			productsWithMustHaveDto.add(productWithMustHaveDto);
		}
		
		// puis j'ajoute ces DTO à mon categoryDto
		categoryDto.setProductWithMustHaveDto(productsWithMustHaveDto);
		
		// je renvoi le tout.
		return categoryDto;
	}
	
	// on récupère les produits liés à cette categorie
	
	
	@GetMapping("/test/{id}")
	public Category getCategory(@PathVariable(required = true) Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)) ;
	}
}
