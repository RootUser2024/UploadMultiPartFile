package com.example.demo.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.QualtricsDetails;
import com.example.demo.repository.QualtricsRepository;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
public class QualtricsController {
	
	@Autowired
	QualtricsRepository service;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
		List<QualtricsDetails> qualtricsDetails = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings settings = new CsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(settings);
		List<com.univocity.parsers.common.record.Record> parseRecords = parser.parseAllRecords(inputStream);
		parseRecords.forEach(record -> {
			QualtricsDetails details = new QualtricsDetails();
			details.setId(Integer.parseInt(record.getString("flow_id")));
			details.setFlowname(record.getString("flowname"));
			details.setFlowregion(record.getString("flowregion"));
			qualtricsDetails.add(details);
		}
		);
		service.saveAll(qualtricsDetails);
		return "Upload Successfull !!!!";
	}

}
