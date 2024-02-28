package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class CallUploadFileService {
	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", "F://MPHASIS//Qualtrics_Details.csv");
		HttpEntity<MultiValueMap<String, Object>> requestEntity
		 = new HttpEntity<>(body, headers);

		String serverUrl = "http://localhost:8080/upload";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate
		  .postForEntity(serverUrl, requestEntity, String.class);
		
		System.out.println(response.getBody().toString());

	}

}
