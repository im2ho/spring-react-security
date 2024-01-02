package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.service.ProductService;
import com.example.vo.Products;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//메서드
	@GetMapping
	public List<Products> getAllProducts(Model model){
		return productService.findAllProducts();
	}
	
	//상품 추가
	@PostMapping("/add")
	public ResponseEntity<Products> addProduct(@RequestBody Products product){
		Products saveProduct = productService.saveProduct(product);
		return ResponseEntity.ok(saveProduct);
	}
	
	//상품 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		productService.deleteProductById(id);
		return ResponseEntity.ok("상품 삭제 성공");
	}
	
	//상품 수정
	@PutMapping("/update/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable Long id,
												@RequestBody Products updatedProduct){
		Products existProduct = productService.findProductsById(id);
		existProduct.setName(updatedProduct.getName());
		existProduct.setPrice(updatedProduct.getPrice());
		
		Products updateProduct = productService.saveProduct(existProduct);
		return ResponseEntity.ok(updateProduct);
	}
}
