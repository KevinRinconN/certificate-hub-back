package com.bovintech.versionone.domain.certification.model;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CertificationDTO {
    private Long id;
    private Long consecutive;
    private Long clientConsecutive;
    private String address;
    private String nameCompany;
    private String phone;
    private String email;
    private String ciu;
    private Integer validateBy;
    private LocalDate date;
    private InspectorDTO inspector;
    private SeasonDTO season;
    private CompanyDTO company;

    public boolean isActive() {
        // Verifica si la fecha actual está dentro del periodo de validez
        if (date != null && validateBy != null) {
            LocalDate expiryDate = date.plusYears(validateBy); // Calcula la fecha de expiración
            return LocalDate.now().isBefore(expiryDate) || LocalDate.now().isEqual(expiryDate);
        }
        return false; // Si no se puede determinar la vigencia, se asume que no está vigente
    }

    public String getFormatConsecutive () {
        String prefix = this.season.getPrefix();
        return String.format("pr-%d-%s",
                this.clientConsecutive,
                prefix != null ? prefix : "unknown");
    }
}
