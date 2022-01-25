package com.ai.queue.repository;

import com.ai.queue.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<GroupEntity, String> {
    List<GroupEntity> findAllBySpecialityId(Integer specialityId);
}
