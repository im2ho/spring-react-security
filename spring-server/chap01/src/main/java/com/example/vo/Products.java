package com.example.vo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name="product_seq", sequenceName="product_seq", allocationSize=1)
	private Long id;
	
	private String name;
	
	private double price;
}