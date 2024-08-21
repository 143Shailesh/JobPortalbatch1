package com.example.JobPortalbatch1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobSeekerProfile {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String resume;
        private String url;
        private String certifications;
        private String Skills;
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private User user;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "job_applications",
                joinColumns = @JoinColumn(name = "job_seeker_profile_id"),
                inverseJoinColumns = @JoinColumn(name = "job_id")
        )

        private Set<Job> appliedJobs;



}
