package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.model.Products;
import com.kh.service.ProductService;

@RestController //api로 전달받을 수 있게 해주는 controller
@RequestMapping("/api/product")
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true", allowedHeaders="*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/item")
	public ResponseEntity<List<Products>> getAllProduct() {
		List<Products> products = productService.getAllProduct();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody Products product){
		productService.addProduct(product);
		return ResponseEntity.ok("상품 추가 성공");
	}
}
