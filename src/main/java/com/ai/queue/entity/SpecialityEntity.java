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
@Table(name = "SPECIALITY")
public class SpecialityEntity {
    @Id
    private Integer id;
    @Column(name = "SPECIALITY_NAME")
    private String name;
    private String abbrev;
    private Integer educationFormId;
    private String educationFormName;
    private Integer facultyId;
    private String code;
}
