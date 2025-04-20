package com.management.wastemanagement.controller;

import com.management.wastemanagement.models.Subscription;
import com.management.wastemanagement.models.User;
import com.management.wastemanagement.repository.UserRepository;
import com.management.wastemanagement.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserRepository userRepository;

    // ADMIN: View all subscriptions
    @GetMapping
    public ResponseEntity<List<Subscription>> getAll() {
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

    // USER: View only own subscriptions
    @GetMapping("/my")
    public ResponseEntity<List<Subscription>> getMySubscriptions(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("User not found"));
        return ResponseEntity.ok(subscriptionService.getSubscriptionsByUserId(user.getId()));
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // USER: Create subscription
    @PostMapping
    public ResponseEntity<Subscription> create(@RequestBody Subscription subscription, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("User not found"));
        subscription.setUser(user);
        return ResponseEntity.ok(subscriptionService.createSubscription(subscription));
    }

    // USER: Update own subscription
    @PutMapping("/{id}")
    public ResponseEntity<Subscription> update(@PathVariable Long id,
                                               @RequestBody Subscription sub,
                                               Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        Subscription existing = subscriptionService.getSubscriptionById(id).orElseThrow();

        if (!existing.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build(); // Forbidden
        }

        return ResponseEntity.ok(subscriptionService.updateSubscription(id, sub));
    }

    // ADMIN or OWNER: Delete subscription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        Subscription sub = subscriptionService.getSubscriptionById(id).orElseThrow();

        if (!user.getRole().equalsIgnoreCase("ADMIN") &&
                !sub.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok().build();
    }
}
