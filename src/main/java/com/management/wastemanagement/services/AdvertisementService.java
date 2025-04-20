package com.management.wastemanagement.services;

import com.management.wastemanagement.models.Advertisement;
import com.management.wastemanagement.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    public List<Advertisement> getAllAds() {
        return advertisementRepository.findAll();
    }

    public Optional<Advertisement> getAdById(Long id) {
        return advertisementRepository.findById(id);
    }

    public Advertisement createAd(Advertisement ad) {
        return advertisementRepository.save(ad);
    }

    public Advertisement updateAd(Long id, Advertisement updatedAd) {
        return advertisementRepository.findById(id)
                .map(ad -> {
                    ad.setAdvertiserName(updatedAd.getAdvertiserName());
                    ad.setAdContent(updatedAd.getAdContent());
                    ad.setStartDate(updatedAd.getStartDate());
                    ad.setEndDate(updatedAd.getEndDate());
                    return advertisementRepository.save(ad);
                })
                .orElseThrow(() -> new RuntimeException("Advertisement not found with id " + id));
    }

    public void deleteAd(Long id) {
        advertisementRepository.deleteById(id);
    }
}
