package com.kh.springChap01.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name="product_seq", sequenceName="product_seq", allocationSize=1)
	private Long id;
	private String name;
	private double price;
}