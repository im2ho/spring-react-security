package com.kh.controller;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-data")
public class ApiDBController {

	/*
	 produces = MedialType.TEXT_PLAIN_VALUE
	 가져올 데이터 타입을 지정해주는 메서드
	 MediaType 해준 다음 텍스트 파일을 가져올 것인지 다른 파일을 가져올 것인지 작성
	 텍스트/plain 미디어 타입을 생성하겠다는 표시 (텍스트 형식의 응답을 생성)
	*/
	
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<InputStreamResource> csvData(){
		
		try {
			
			String csvFileName = "cultureMap.csv";
			Path csvFilePath = Paths.get(ApiDBController.class.getClassLoader().getResource(csvFileName).toURI());
			

			/*
				InputStreamResource : Spring에서 제공하는 클래스로,
				FileInputStream을 spring에서 resource로 감싸는 역할로, 파일이나 다른 소스로부터 읽어온 데이터를 Spring에서 관리되는 소스로 사용할 수 있게 해줌
				
				가져온 파일을 spring으로 읽어올 경우 
				File file = new file("exam.txt");
				InputStream inputStream = new FileInputStream(file);
				InputStreamResource resource = new InputStreamResource(inputStream);
				
				파일을 InputStream 사용해서 Spring 형식으로 변환하는 과정
			*/
			InputStreamResource resource = new InputStreamResource(new FileInputStream(csvFilePath.toFile()));
			
			/*
				Http 응답 헤더 설정
				CONTENT_DISPOSITION : 파일을 어떻게 처리할지 브라우저에 알리는 역할
				inline : 브라우저가 해당 파일을 표시할 수 있는 경우에만 화면에 표시할 수 있도록 지정 에러를 최소화
				filename : 브라우저 들어왔을 때 파일 다운로드 이름을 지정
			*/
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + csvFileName);
			return ResponseEntity.ok().headers(headers).body(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	} 
	
}
