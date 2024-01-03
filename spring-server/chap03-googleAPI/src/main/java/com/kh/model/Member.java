package com.kh.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq")
	@SequenceGenerator(name="member_seq", sequenceName="member_seq", allocationSize=1)
	private Long id;
	
	private String email;
	private String name;
	
	
	//생성자------------------------------
	
	public Member() {}
	
	public Member(String email, String name) {
		this.email = email;
		this.name = name;
	}
	
}