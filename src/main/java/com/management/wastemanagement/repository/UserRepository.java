package com.management.wastemanagement.repository;

import com.management.wastemanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {

    static User getId(int i) {
        return null;
    }
}
