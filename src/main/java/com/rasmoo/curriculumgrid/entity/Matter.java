package com.rasmoo.curriculumgrid.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_MATTER")
@NoArgsConstructor
public class Matter extends BaseEntity<Long> implements Serializable{
	private static final long serialVersionUID = -1747656972646950818L;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "HOURS")
	private int hours;
	
	@Column(name = "FREQUENCY")
	private int frequency;	
}