package com.example.JobPortalbatch1.Repository;

import com.example.JobPortalbatch1.model.EmployerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerProfileRepository extends JpaRepository<EmployerProfile, Integer> {
}
