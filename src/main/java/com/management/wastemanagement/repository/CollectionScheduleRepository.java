package com.management.wastemanagement.repository;

import com.management.wastemanagement.models.CollectionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionScheduleRepository extends JpaRepository<CollectionSchedule, Long> {
}
