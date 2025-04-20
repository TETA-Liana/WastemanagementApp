package com.management.wastemanagement.services;

import com.management.wastemanagement.models.WasteCollector;
import com.management.wastemanagement.repository.WasteCollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCollectorService {

    private final WasteCollectorRepository collectorRepository;

    @Autowired
    public WasteCollectorService(WasteCollectorRepository collectorRepository) {
        this.collectorRepository = collectorRepository;
    }

    public List<WasteCollector> getAllCollectors() {
        return collectorRepository.findAll();
    }

    public Optional<WasteCollector> getCollectorById(Long id) {
        return collectorRepository.findById(id);
    }

    public WasteCollector createCollector(WasteCollector collector) {
        return collectorRepository.save(collector);
    }

    public WasteCollector updateCollector(Long id, WasteCollector updatedCollector) {
        return collectorRepository.findById(id)
                .map(collector -> {
                    collector.setName(updatedCollector.getName());
                    collector.setContactNumber(updatedCollector.getContactNumber());
                    collector.setServiceArea(updatedCollector.getServiceArea());
                    return collectorRepository.save(collector);
                })
                .orElseThrow(() -> new RuntimeException("Collector not found with ID: " + id));
    }

    public void deleteCollector(Long id) {
        collectorRepository.deleteById(id);
    }
}
