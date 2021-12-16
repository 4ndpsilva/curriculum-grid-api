package com.rasmoo.curriculumgrid.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_MATTER")
public class Matter extends BaseEntity<Long> implements Serializable{
	private static final long serialVersionUID = -1747656972646950818L;

	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "HOURS")
	private int hours;
	
	@Column(name = "FREQUENCY")
	private int frequency;	
}