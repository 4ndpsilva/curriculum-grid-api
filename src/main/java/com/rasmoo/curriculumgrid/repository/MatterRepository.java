package com.rasmoo.curriculumgrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rasmoo.curriculumgrid.entity.Matter;

public interface MatterRepository extends JpaRepository<Matter, Long>{}