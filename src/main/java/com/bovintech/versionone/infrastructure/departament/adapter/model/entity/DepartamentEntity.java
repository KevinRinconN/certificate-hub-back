package com.bovintech.versionone.infrastructure.departament.adapter.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departament")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coordinatorName;
    private String coordinatorOccupation;
    private String coordinatorSign;
}
