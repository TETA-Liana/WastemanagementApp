package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.RecyclingRequest;
import com.management.wastemanagement.services.RecyclingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recycling")
@CrossOrigin(origins = "http://localhost:8081")
public class RecyclingRequestController {

    private final RecyclingRequestService recyclingService;

    @Autowired
    public RecyclingRequestController(RecyclingRequestService recyclingService) {
        this.recyclingService = recyclingService;
    }

    @GetMapping
    public List<RecyclingRequest> getAllRequests() {
        return recyclingService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingRequest> getRequestById(@PathVariable Long id) {
        return recyclingService.getRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RecyclingRequest createRequest(@RequestBody RecyclingRequest request) {
        return recyclingService.createRequest(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingRequest> updateRequest(@PathVariable Long id, @RequestBody RecyclingRequest updatedRequest) {
        try {
            RecyclingRequest request = recyclingService.updateRequest(id, updatedRequest);
            return ResponseEntity.ok(request);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long id) {
        recyclingService.deleteRequest(id);
        return ResponseEntity.ok("Recycling request deleted successfully");
    }
}
