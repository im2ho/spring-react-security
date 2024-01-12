package com.kh.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//xml로 된 파일을 가져왔을 때
//최종적으로 리턴하는 종류가 html-> @Controller
//최종적으로 리턴하는 종류가 backend api 주소 -> @RestController

@RestController
public class ApiXmlController {

	@GetMapping("/api_exlporer")
	public ResponseEntity<?> xmlApi() {
		//파일을 가지고 올 때 항상 String Builder
		//파일 내용이 들어갈 Builder를 미리 세팅해서 비어있는 Builder 안에 가져온 내용을 채울 예정
		StringBuilder result = new StringBuilder();
		
		// 1. apiUrl 2. Key 3. xml 형식으로 가져오기
		// xml 파일을 주소값이 아닌, 다운받아 사용하는 것이라면 apiUrl 및 key 값이 필요하지 않음
		// 파일의 위치와 파일을 변환해주는 작업이 필요
		// 파일을 가져올 때는 Buffer와 Stream을 사용하자 > xml 파일을 json 형식으로 변환해서 출력 예정
		
		// key value
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		
		// return data key 목록 담을 공간
		List<String> headerList = new ArrayList<String>();
		try {
			
			BufferedReader br = Files.newBufferedReader(Paths.get("isgi.d_0001.xml"));
			String line = "";
			
			//**readLine() : 문서를 한 줄씩 읽어서 문자열을 return해주는 메서드
			//**split() : 입력 받은 형식을 정규 표현식이나 특정 문자를 기준으로 문자열을 나누어 배열에 저장해서 return
 			while((line = br.readLine()) != null) {
				List<String> stringList = new ArrayList<String>();
				String stringArray[] = line.split("xml 형식에 맞춰서 다듬기");
				stringList = Arrays.asList(stringArray);
				
				//맨 위가 어디인지 확인 후 header 인식
				//꼭대기를 찾아주고 나서 데이터를 변환해서 json형식으로 출력
				if(headerList.size() ==  0) {
					headerList = stringList;
				} else {
					Map<String, Object> map = new HashMap<String, Object>();
					
					//읽어온 header 컬럼 개수를 기준으로 데이터 출력
					for(int i=0 ; i < headerList.size() ; i++) {
						map.put(headerList.get(i), stringList.get(i));
					}
					mapList.add(map);
				} //if else
			} //while
 			
 			System.out.println(mapList);
 			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	} //xmlApi()
} //class