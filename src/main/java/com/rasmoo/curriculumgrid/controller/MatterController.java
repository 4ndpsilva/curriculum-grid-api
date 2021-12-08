package com.rasmoo.curriculumgrid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matters")
public class MatterController {
	
	@GetMapping
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.status(HttpStatus.OK).body("OLA MUNDO REST");
	}
}