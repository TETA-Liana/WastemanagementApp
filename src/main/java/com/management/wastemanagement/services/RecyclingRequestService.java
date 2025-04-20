package com.management.wastemanagement.services;

import com.management.wastemanagement.models.RecyclingRequest;
import com.management.wastemanagement.repository.RecyclingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingRequestService {

    private final RecyclingRequestRepository requestRepository;

    @Autowired
    public RecyclingRequestService(RecyclingRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<RecyclingRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<RecyclingRequest> getRequestById(Long id) {
        return requestRepository.findById(id);
    }

    public RecyclingRequest createRequest(RecyclingRequest request) {
        return requestRepository.save(request);
    }

    public RecyclingRequest updateRequest(Long id, RecyclingRequest updatedRequest) {
        return requestRepository.findById(id)
                .map(request -> {
                    request.setUser(updatedRequest.getUser());
                    request.setItemType(updatedRequest.getItemType());
                    request.setQuantity(updatedRequest.getQuantity());
                    request.setStatus(updatedRequest.getStatus());
                    request.setRequestDate(updatedRequest.getRequestDate());
                    return requestRepository.save(request);
                })
                .orElseThrow(() -> new RuntimeException("RecyclingRequest not found with id: " + id));
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}
