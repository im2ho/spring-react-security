package com.kh.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class MemberGoogle {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mg_seq")
	@SequenceGenerator(name="mg_seq", sequenceName="mg_seq", allocationSize=1)
	private Long id;
	
	private String email;
	private String username;
	
}