package com.ai.queue.repository;

import com.ai.queue.entity.SpecialityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<SpecialityEntity, Integer> {
    List<SpecialityEntity> findAllByFacultyId(Integer facultyId);
}
