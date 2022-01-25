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
@Table(name = "STUDENT_GROUP")
public class GroupEntity {
    @Id
    @Column(name = "GROUP_NAME")
    private String name;
    private Integer facultyId;
    private Integer specialityId;
    private Integer course;
  /*  @Id
    private Integer id;*/
}
