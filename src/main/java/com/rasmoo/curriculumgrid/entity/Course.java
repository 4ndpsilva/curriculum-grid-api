package com.rasmoo.curriculumgrid.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_COURSE")
public class Course extends BaseEntity<Long> implements Serializable {
    private static final long serialVersionUID = 2103022088451472375L;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "NAME")
    private String name;
}