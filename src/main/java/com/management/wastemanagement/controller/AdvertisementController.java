package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.Advertisement;
import com.management.wastemanagement.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ads")
@CrossOrigin(origins = "http://localhost:8081")
public class AdvertisementController {

    private final AdvertisementService adService;

    @Autowired
    public AdvertisementController(AdvertisementService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<Advertisement> getAllAds() {
        return adService.getAllAds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdById(@PathVariable Long id) {
        return adService.getAdById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Advertisement createAd(@RequestBody Advertisement ad) {
        return adService.createAd(ad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advertisement> updateAd(@PathVariable Long id, @RequestBody Advertisement updatedAd) {
        try {
            Advertisement ad = adService.updateAd(id, updatedAd);
            return ResponseEntity.ok(ad);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
        return ResponseEntity.ok("Ad deleted successfully");
    }
}
