package com.management.wastemanagement.repository;

import com.management.wastemanagement.models.RecyclingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingRequestRepository extends JpaRepository<RecyclingRequest, Long> {
}
