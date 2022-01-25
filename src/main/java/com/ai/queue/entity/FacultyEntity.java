package com.ai.queue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FACULTY")
public class FacultyEntity {
    @Id
    private Integer id;
    @Column(name = "FACULTY_NAME")
    private String name;
    private String cypher;
}
