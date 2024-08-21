package com.example.JobPortalbatch1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int experience;
    private String location;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_profile_id")
    @JsonIgnore
    private EmployerProfile employerProfile;

    @ManyToMany(mappedBy = "applyJobs",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<JobSeekerProfile> applicants;
}
