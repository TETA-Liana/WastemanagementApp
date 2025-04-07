package com.management.wastemanagement;

import com.management.wastemanagement.models.Address;
import com.management.wastemanagement.models.Subscription;
import com.management.wastemanagement.repository.SubscriptionRepository;
import com.management.wastemanagement.repository.UserRepository;
import com.management.wastemanagement.models.Address;
import com.management.wastemanagement.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WasteManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(WasteManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        return args -> {
            Address homeAddres=new Address("Nyabihu","Mukamira","Kamashashi","Karandaryi");
            // Creating and saving users
            User user = new User("liana", "liana@gmail.com", "1234", "manager");
            userRepository.save(user);
            User user1 = new User("humura", "humura@gmail.com", "456", "worker");
            User user2 = new User("Ineza", "Ineza@gmail.com", "789", "manager");

            List<User> users = new ArrayList<>();
            userRepository.saveAndFlush(user);
            users.add(user1);
            users.add(user2);
         //   userRepository.saveAll(users);

            userRepository.saveAll(users);
            userRepository.flush(); // Forces immediate synchronization with DB

            // Display saved users
            List<User> savedUsers = userRepository.findAll();
            for (User u : savedUsers) {
                System.out.println(u);
            }
            User user5=userRepository.findById(user1.getId()).get();
            user5.setName("Mwiza");
            userRepository.saveAndFlush(user5);

            // Updating a user
            User user4 = userRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            user4.setName("Keza");
            userRepository.save(user4);

            // Creating a Subscription with correct date and time settings
            LocalDateTime startDate = LocalDateTime.of(2020, Month.DECEMBER, 21, 0, 0);
            LocalDateTime endDate = LocalDateTime.of(2021, Month.JULY, 28, 0, 0);

            Subscription s1 = new Subscription(user, "premium", startDate, endDate, 500);
            subscriptionRepository.save(s1);
        };
    }
}
