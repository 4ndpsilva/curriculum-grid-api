package com.rasmoo.curriculumgrid.controller;

import com.rasmoo.curriculumgrid.dto.CourseDTO;
import com.rasmoo.curriculumgrid.entity.Course;
import com.rasmoo.curriculumgrid.mapper.GenericMapper;
import com.rasmoo.curriculumgrid.service.core.AbstractCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final AbstractCrudService<Course, Long> service;
    private final GenericMapper<Course, CourseDTO> mapper;

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody @Valid final CourseDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDTO(service.save(mapper.mapToEntity(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable final Long id, @RequestBody @Valid final CourseDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.mapToDTO(service.update(id, mapper.mapToEntity(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToDTO(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> list(@RequestParam final Map<String, Object> params) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapToListDTO(service.find(params)));
    }
}