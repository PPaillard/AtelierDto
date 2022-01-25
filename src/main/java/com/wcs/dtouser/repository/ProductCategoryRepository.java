package com.wcs.dtouser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcs.dtouser.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
