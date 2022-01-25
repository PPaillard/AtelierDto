package com.wcs.dtouser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcs.dtouser.entity.Category;

public interface CategoryRepository extends  JpaRepository<Category, Long> {

}
