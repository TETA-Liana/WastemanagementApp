package com.management.wastemanagement.repository;

import com.management.wastemanagement.models.WasteReport;
import com.management.wastemanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteReportRepository extends JpaRepository<WasteReport, Long> {
    List<WasteReport> findByUser(User user);
}
