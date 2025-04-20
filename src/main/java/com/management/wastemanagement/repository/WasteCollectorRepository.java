package com.management.wastemanagement.repository;

import com.management.wastemanagement.models.WasteCollector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCollectorRepository extends JpaRepository<WasteCollector, Long> {
}
