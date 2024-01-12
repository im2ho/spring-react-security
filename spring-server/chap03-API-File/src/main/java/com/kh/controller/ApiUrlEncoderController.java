package com.kh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUrlEncoderController {

	@GetMapping("/api/encoder/data")
	public String allowBasic() {
		
		StringBuffer result = new StringBuffer();

		try {
			StringBuilder urlBuilder = new StringBuilder("http://www.emuseum.go.kr/openapi/code");
			urlBuilder.append("?serviceKey=lcrUnJspb%2BqNeAR5t8cAoQY9a97uknh8KGH146DQag%2FGS95Tma4%2BoXJjS%2Bby8DTzvFrI8tM2EjCZdM5TCclJAw%3D%3D");
			urlBuilder.append("&pageNo=1");
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&parentCode=PS01");
			//결과로 보여줄 포멧을 만약 XML로 보여주고싶다면 XML 설정
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd;
			
			//만약 response코드가 200보다 크거나 300보다 작을 경우
			//Http : 응답코드 200 ~ 229 성공
			//		 응답코드 300 ~ 300 redirection
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				//실패했을 경우
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			String line;
			while((line = rd.readLine()) != null) {
				result.append(line).append("\n");
			}
			rd.close();
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
}
