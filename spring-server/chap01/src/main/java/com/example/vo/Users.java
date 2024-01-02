package com.example.vo;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="uses_seq")
	@SequenceGenerator(name="users_seq", sequenceName="users_seq",allocationSize=1)
	private Long id;
	private String username;
	private String email;
}