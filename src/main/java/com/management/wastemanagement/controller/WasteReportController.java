package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.WasteReport;
import com.management.wastemanagement.service.WasteReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-reports")
public class WasteReportController {

    @Autowired
    private WasteReportService wasteReportService;

    // POST: Create report
    @PostMapping("/user/{userId}")
    public ResponseEntity<WasteReport> createReport(@PathVariable Long userId, @RequestBody WasteReport report) {
        return ResponseEntity.ok(wasteReportService.createReport(userId, report));
    }

    // GET: Get all (admin)
    @GetMapping("/all")
    public ResponseEntity<List<WasteReport>> getAllReports() {
        return ResponseEntity.ok(wasteReportService.getAllReports());
    }

    // GET: Get by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WasteReport>> getReportsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(wasteReportService.getReportsByUserId(userId));
    }

    // PUT: Update
    @PutMapping("/{id}")
    public ResponseEntity<WasteReport> updateReport(@PathVariable Long id, @RequestBody WasteReport report) {
        return ResponseEntity.ok(wasteReportService.updateReport(id, report));
    }

    // DELETE: Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        wasteReportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
