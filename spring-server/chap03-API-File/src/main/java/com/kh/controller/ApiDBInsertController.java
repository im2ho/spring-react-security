package com.kh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class ApiDBInsertController {

    @GetMapping("/map_info")
    public String DBInsert() {

		//데이터를 시작하기 전에는 StringBuilder
        StringBuilder result = new StringBuilder();

        try {
        	
        	/*
        	 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst"); 
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); 
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode("108", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode("201310170600", "UTF-8")); 
        	 */
            String apiUrl = "http://apis.data.go.kr/B550928/dissForecastInfoSvc/getDissForecastInfo";	
            String apiKey = "65liqYkK/8aC6Rh048XPwFgemJxH+MbwP3xXZX99CvFgz0Fu4q+dhC5NIQlLfrLVjpnKo8xX6yALLyPhICI0HQ==";
            String pageNo = "1";
            String numOfRows = "10";
            String responseType = "xml";
            String stnId = "108";
            String tmFc = "202401091500";
            
            String encodedApiKey = URLEncoder.encode(apiKey, "UTF-8");
           
            String encodedUrl = String.format("%s?serviceKey=%s&pageNo=%s&numOfRow=%s&dataType=%s&stnId=%s&tmFc=%s",
                    apiUrl, encodedApiKey, pageNo, numOfRows, responseType, stnId, tmFc);

            URL url = new URL(encodedUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            connection.disconnect();

            insertIntoOracleDB(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    @GetMapping("/map_info/add")
    private void insertIntoOracleDB(String data) {
    	        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    	        String username = "react";
    	        String password = "react";

    	        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
    	            String sql = "INSERT INTO culture (id, data) VALUES (culter_seq.NEXTVAL, ?)";
    	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
    	                statement.setString(1, data);
    	                statement.executeUpdate();
    	            }

    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    }
}