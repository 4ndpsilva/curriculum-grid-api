package com.rasmoo.curriculumgrid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_MATTER")
public class Matter implements Serializable{
	private static final long serialVersionUID = -1747656972646950818L;
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ID")
	private Long id;
	
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