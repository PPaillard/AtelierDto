package com.wcs.dtouser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wcs.dtouser.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
