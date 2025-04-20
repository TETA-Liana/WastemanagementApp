package com.management.wastemanagement.services;

import com.management.wastemanagement.models.Subscription;
import com.management.wastemanagement.models.User;
import com.management.wastemanagement.repository.SubscriptionRepository;
import com.management.wastemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    public List<Subscription> getSubscriptionsByUserId(Long userId) {
        return subscriptionRepository.findAll().stream()
                .filter(s -> s.getUser().getId().equals(userId))
                .toList();
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(Long id, Subscription updatedSub) {
        return subscriptionRepository.findById(id).map(subscription -> {
            subscription.setPlanType(updatedSub.getPlanType());
            subscription.setStartDate(updatedSub.getStartDate());
            subscription.setEndDate(updatedSub.getEndDate());
            subscription.setPrice(updatedSub.getPrice());
            return subscriptionRepository.save(subscription);
        }).orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
