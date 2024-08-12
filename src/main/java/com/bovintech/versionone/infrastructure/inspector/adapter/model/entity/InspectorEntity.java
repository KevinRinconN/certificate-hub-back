package com.bovintech.versionone.infrastructure.inspector.adapter.model.entity;

import com.bovintech.versionone.infrastructure.certification.adapter.model.entity.CertificationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "inspector")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class    InspectorEntity {
    @Id
    private String username;
    @Column(nullable = false, length = 40)
    private String firstname;
    @Column(nullable = false, length = 40)
    private String lastname;
    @Column(name = "display_name" ,nullable = false, length = 30)
    private String displayName;
    @Column(nullable = false, length = 30)
    private String occupation;
    @Column(nullable = false)
    private String signature;

    @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CertificationEntity> certifications;
}
