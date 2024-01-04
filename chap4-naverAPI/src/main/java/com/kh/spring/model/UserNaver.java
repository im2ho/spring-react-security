package com.kh.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@Entity
public class UserNaver {

	@Id
	private String name;
	private String email;

}