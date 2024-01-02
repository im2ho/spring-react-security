package com.kh.springChap01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springChap01.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long>{

}
