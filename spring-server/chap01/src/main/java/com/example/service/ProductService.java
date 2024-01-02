package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.respository.ProductRepository;
import com.example.vo.Products;

@Service
public class ProductService {

	//멤버변수
	private ProductRepository productRepository;
	
	//생성자
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	//메서드
	
	//전체 상품 조회
	public List<Products> findAllProducts(){
		return productRepository.findAll();
	}
	
	//상품 조회 by id
	public Products findProductsById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	//상품 등록
	public Products saveProduct(Products product) {
		return productRepository.save(product);
	}
	
	//상품 삭제 by id
	public void deleteProductById(Long product_id) {
		productRepository.deleteById(product_id);
	}
}
