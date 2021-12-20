package com.rasmoo.curriculumgrid.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_COURSE")
@NoArgsConstructor
public class Course extends BaseEntity<Long> implements Serializable {
    private static final long serialVersionUID = 2103022088451472375L;

    @Column(name = "NAME")
    private String name;
}