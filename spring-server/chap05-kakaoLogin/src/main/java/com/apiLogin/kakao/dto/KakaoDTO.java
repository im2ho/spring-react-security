package com.apiLogin.kakao.dto;

import lombok.*;

@Builder
@Data
public class KakaoDTO {

	private long id;
	private String nickname;
	private String email;
}
