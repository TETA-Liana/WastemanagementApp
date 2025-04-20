package com.management.wastemanagement.services;

import com.management.wastemanagement.models.CollectionSchedule;
import com.management.wastemanagement.repository.CollectionScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionScheduleService {

    private final CollectionScheduleRepository scheduleRepository;

    @Autowired
    public CollectionScheduleService(CollectionScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<CollectionSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<CollectionSchedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public CollectionSchedule createSchedule(CollectionSchedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public CollectionSchedule updateSchedule(Long id, CollectionSchedule updatedSchedule) {
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setCollector(updatedSchedule.getCollector());
                    schedule.setLocation(updatedSchedule.getLocation());
                    schedule.setCollectionTime(updatedSchedule.getCollectionTime());
                    return scheduleRepository.save(schedule);
                })
                .orElseThrow(() -> new RuntimeException("Schedule not found with id " + id));
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
