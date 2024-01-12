package com.kh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping("/api/get")
	public String allowBasic() {
		
		StringBuilder result = new StringBuilder();
		
		try {
			String apiUrl = "http://www.emuseum.go.kr/openapi/code";
			String apiKey="lcrUnJspb+qNeAR5t8cAoQY9a97uknh8KGH146DQag/GS95Tma4+oXJjS+by8DTzvFrI8tM2EjCZdM5TCclJAw==";
			String numOfRows="10";
			String pageNo="1";
			String parentCode="PS01";
			
			//Encode the parameters
			String encodedApiKey = URLEncoder.encode(apiKey,"UTF-8");
			String encodedUrl = String.format(
					"%s?serviceKey=%s&pageNo=%s&numOfRows=%s&parentCode=%s",
					apiUrl, encodedApiKey, pageNo, numOfRows, parentCode);
			
			//Create Http connection
			URL url = new URL(encodedUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
			 
            //Get the response 응답에 대한 값을 전달
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
}
