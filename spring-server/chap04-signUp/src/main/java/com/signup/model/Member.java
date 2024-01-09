package com.signup.model;


import java.sql.Date;

import lombok.*;

@Getter @Setter
public class Member {

	//mapper.xml 파일이랑 변수명 맞추기
	private Long memberId;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private Date registrationDate;
	
}
