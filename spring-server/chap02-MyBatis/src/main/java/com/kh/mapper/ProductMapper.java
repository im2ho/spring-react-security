package com.kh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.model.Products;

//JpaRepository와 같은 기능 (인터페이스)
@Mapper
public interface ProductMapper {
	//src/main/resources/mapper/ProductMapper.xml밑에 작성해준 SQL id만 작성
	//JPA처럼 mapper.xml 파일에는 작성하지 않은 SQL문과 id에 관련된 메서드를 모두 작성해주면
	//mapper.xml 밑에는 사용할 수 없는 id가 바라보기 때문에 에러 발생
	
	//전체 상품 조회
	List<Products> getAllProduct();
	
	//상품 등록
	void addProduct(Products product);
}
