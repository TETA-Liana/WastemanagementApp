package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.WasteCollector;
import com.management.wastemanagement.services.WasteCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/collectors")
@CrossOrigin(origins = "http://localhost:8081")
public class WasteCollectorController {

    private final WasteCollectorService collectorService;

    @Autowired
    public WasteCollectorController(WasteCollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping
    public List<WasteCollector> getAllCollectors() {
        return collectorService.getAllCollectors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCollector> getCollectorById(@PathVariable Long id) {
        return collectorService.getCollectorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WasteCollector createCollector(@RequestBody WasteCollector collector) {
        return collectorService.createCollector(collector);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCollector> updateCollector(@PathVariable Long id, @RequestBody WasteCollector updatedCollector) {
        try {
            WasteCollector collector = collectorService.updateCollector(id, updatedCollector);
            return ResponseEntity.ok(collector);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollector(@PathVariable Long id) {
        collectorService.deleteCollector(id);
        return ResponseEntity.ok("Collector deleted successfully");
    }
}
