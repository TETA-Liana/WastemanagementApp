package com.management.wastemanagement.service;

import com.management.wastemanagement.models.User;
import com.management.wastemanagement.models.WasteReport;
import com.management.wastemanagement.repository.UserRepository;
import com.management.wastemanagement.repository.WasteReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WasteReportService {

    @Autowired
    private WasteReportRepository wasteReportRepository;

    @Autowired
    private UserRepository userRepository;

    public WasteReport createReport(Long userId, WasteReport report) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        report.setUser(userOptional.get());
        report.setReportedAt(LocalDateTime.now());

        return wasteReportRepository.save(report);
    }

    public List<WasteReport> getAllReports() {
        return wasteReportRepository.findAll();
    }

    public List<WasteReport> getReportsByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(wasteReportRepository::findByUser).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteReport(Long id) {
        wasteReportRepository.deleteById(id);
    }

    public WasteReport updateReport(Long id, WasteReport updated) {
        WasteReport report = wasteReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setWasteType(updated.getWasteType());
        report.setQuantity(updated.getQuantity());
        report.setLocation(updated.getLocation());

        return wasteReportRepository.save(report);
    }
}
