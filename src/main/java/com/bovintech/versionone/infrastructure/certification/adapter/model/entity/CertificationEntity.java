package com.bovintech.versionone.infrastructure.certification.adapter.model.entity;

import com.bovintech.versionone.infrastructure.company.adapter.model.entity.CompanyEntity;
import com.bovintech.versionone.infrastructure.inspector.adapter.model.entity.InspectorEntity;
import com.bovintech.versionone.infrastructure.season.adapter.model.entity.SeasonEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "certification")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CertificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long consecutive;
    private Integer validateBy;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private InspectorEntity inspector;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private SeasonEntity season;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
}
