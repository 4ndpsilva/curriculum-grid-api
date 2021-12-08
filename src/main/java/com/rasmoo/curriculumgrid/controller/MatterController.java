package com.rasmoo.curriculumgrid.controller;

import com.rasmoo.curriculumgrid.dto.MatterDTO;
import com.rasmoo.curriculumgrid.entity.Matter;
import com.rasmoo.curriculumgrid.mapper.MatterMapper;
import com.rasmoo.curriculumgrid.service.CrudService;
import com.rasmoo.curriculumgrid.service.MatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matters")
public class MatterController {
	private final CrudService<Matter, Long> service;
	private final MatterMapper mapper;

	@PostMapping
	public ResponseEntity<MatterDTO> save(@RequestBody MatterDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.save(mapper.map(dto))));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MatterDTO> update(@PathVariable Long id, @RequestBody MatterDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.update(id, mapper.map(dto))));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MatterDTO> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(service.findById(id)));
	}

	@GetMapping
	public ResponseEntity<List<MatterDTO>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(mapper.map(service.findAll()));
	}
}