package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.CollectionSchedule;
import com.management.wastemanagement.services.CollectionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedules")
@CrossOrigin(origins = "http://localhost:8081")
public class CollectionScheduleController {

    private final CollectionScheduleService scheduleService;

    @Autowired
    public CollectionScheduleController(CollectionScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<CollectionSchedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionSchedule> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CollectionSchedule createSchedule(@RequestBody CollectionSchedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectionSchedule> updateSchedule(@PathVariable Long id, @RequestBody CollectionSchedule updatedSchedule) {
        try {
            CollectionSchedule schedule = scheduleService.updateSchedule(id, updatedSchedule);
            return ResponseEntity.ok(schedule);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Schedule deleted successfully");
    }
}
