package com.example.JobPortalbatch1.Services;

import com.example.JobPortalbatch1.Repository.EmployerProfileRepository;
import com.example.JobPortalbatch1.model.EmployerProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerProfileService {

    private final EmployerProfileRepository employerProfileRepository;

    public EmployerProfileService(EmployerProfileRepository employerProfileRepository) {
        this.employerProfileRepository = employerProfileRepository;
    }

    public EmployerProfile saveEmployerProfile(EmployerProfile employerProfile) {
        return employerProfileRepository.save(employerProfile);
    }

    public List<EmployerProfile>getAllEmployerProfiles() {
        return employerProfileRepository.findAll();
    }

    public Optional<EmployerProfile> getEmployerProfileById(int id) {
        return employerProfileRepository.findById(id);
    }

    public void deleteEmployerProfileById(int id) {
        employerProfileRepository.deleteById(id);
    }

    public EmployerProfile updateEmployerProfile(int id, EmployerProfile employerProfileDetails) {
        Optional<EmployerProfile> employerProfile = employerProfileRepository.findById(id);

        if (employerProfile.isPresent()) {
            EmployerProfile existingProfile = employerProfile.get();
            existingProfile.setWebSiteUrl(employerProfileDetails.getWebSiteUrl());
            existingProfile.setAddress(employerProfileDetails.getAddress());
            existingProfile.setDescription(employerProfileDetails.getDescription());
            existingProfile.setEstablished(employerProfileDetails.getEstablished());
            // You can add more fields to update if necessary

            return employerProfileRepository.save(existingProfile);
        } else {
            // Handle the case where the EmployerProfile was not found
            return null;
        }
    }
}
