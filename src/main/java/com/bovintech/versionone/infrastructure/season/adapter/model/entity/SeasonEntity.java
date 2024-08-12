package com.bovintech.versionone.infrastructure.season.adapter.model.entity;

import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "season")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SeasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CertificationEntity> certifications;
}
