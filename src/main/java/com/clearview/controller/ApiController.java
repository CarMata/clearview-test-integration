package com.clearview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clearview.dto.RequestDTO;
import com.clearview.service.ApiService;

@Controller
public class ApiController {

	@Autowired
	private ApiService apiServiceImpl;
	
	/**
	 * HTTPGet 
	 * 1. Read the IntegrationTest.json file 
	 * 2. Format the data.
	 * 
	 **/
	@GetMapping("/")
	public ResponseEntity<?> formattingData() {
		apiServiceImpl.outputGet();
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/**
	 * HTTPPost 
	 * 1. Send the values from the IntegrationTest.json file into the postman's Raw Body to be read. 
	 * 2. Format the data
	 * 
	 **/
	@PostMapping(value = "/",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveData(@RequestBody RequestDTO request) {	
		apiServiceImpl.outputPost(request);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
