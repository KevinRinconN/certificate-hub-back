package com.bovintech.versionone.infrastructure.company.adapter.model.entity;

import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false)
    private String name;
    @Column(nullable = false, length = 50)
    private String nit;
    @Column(length = 200)
    private String email;
    @Column(length = 20)
    private String phone;

    @OneToMany(mappedBy = "company")
    private List<CertificationEntity> certifications;
}
