package com.rasmoo.curriculumgrid.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasmoo.curriculumgrid.entity.Matter;
import com.rasmoo.curriculumgrid.repository.MatterRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matters")
public class MatterController {
	
	private final MatterRepository repository;

	@PostMapping
	public ResponseEntity<String> save() {
		return ResponseEntity.status(HttpStatus.OK).body("OLA MUNDO REST");
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> update() {
		return ResponseEntity.status(HttpStatus.OK).body("OLA MUNDO REST");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete() {
		return ResponseEntity.status(HttpStatus.OK).body("OLA MUNDO REST");
	}

	@GetMapping
	public ResponseEntity<List<Matter>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> findById() {
		return ResponseEntity.status(HttpStatus.OK).body("OLA MUNDO REST");
	}
}