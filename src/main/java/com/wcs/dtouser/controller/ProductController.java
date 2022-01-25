package com.wcs.dtouser.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.dtouser.dto.CategoryMustHaveDto;
import com.wcs.dtouser.dto.ProductDto;
import com.wcs.dtouser.entity.Category;
import com.wcs.dtouser.entity.Product;
import com.wcs.dtouser.entity.ProductCategory;
import com.wcs.dtouser.repository.CategoryRepository;
import com.wcs.dtouser.repository.ProductCategoryRepository;
import com.wcs.dtouser.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	 
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@PostMapping
	public void create(@Valid @RequestBody ProductDto productDto) {
		
		// Creation du produit avec les infos de la DTO
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product = productRepository.save(product);
		
		// Pour chaque Objet de la DTO contenant une association de catégorie / mustHave
		for(CategoryMustHaveDto categoryMustHaveDto : productDto.getCategories()) {
			
			// on verifie que la catégorie existe toujours bien
			Optional<Category> optCategory = categoryRepository.findById(categoryMustHaveDto.getId());
			
			if(optCategory.isPresent()) {
				// Si c'est le cas, on créé l'objet ProductCategorie
				ProductCategory productCategory = new ProductCategory();
				productCategory.setMustHave(categoryMustHaveDto.isMustHave());
				productCategory.setCategory(optCategory.get());
				productCategory.setProduct(product);
				productCategoryRepository.save(productCategory);
			}
		}
	}
}
