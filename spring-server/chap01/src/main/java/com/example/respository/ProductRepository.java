package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vo.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}