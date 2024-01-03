package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mapper.ProductMapper;
import com.kh.model.Products;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	//전체 상품 조회
	public List<Products> getAllProduct() {
		return productMapper.getAllProduct();
	}
	
	//상품 등록
	public void addProduct(Products product) {
		productMapper.addProduct(product);
	}
}
