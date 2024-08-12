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
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, length = 50)
    private String nit;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 200)
    private String email;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false, length = 50)
    private String ciu;

    @OneToMany(mappedBy = "company")
    private List<CertificationEntity> certifications;
}
