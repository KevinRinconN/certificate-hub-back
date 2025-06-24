package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CreateCertificationDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.constant.CompanyErrorCatalog;
import com.bovintech.versionone.domain.company.model.exception.CompanyBadRequest;
import com.bovintech.versionone.domain.company.model.exception.CompanyNotFoundException;
import com.bovintech.versionone.domain.company.service.CompanyFindByNitService;
import com.bovintech.versionone.domain.company.usecases.CompanyCreateUseCase;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CertificationCreateService {
    private final ICertificationRepository iCertificationRepository;
    private final CompanyCreateUseCase companyCreateUseCase;
    private final CompanyFindByNitService companyFindByNitService;
    private final SeasonGetByIdUseCase seasonGetByIdUseCase;
    private final InspectorGetByIdUseCase inspectorGetByIdUseCase;


    public List<CertificationDTO> execute (List<CreateCertificationDTO> createCertificationDTOs){
        Map<Long, Long> seasonConsecutives = new HashMap<>();
        List<CertificationDTO> certifications = createCertificationDTOs.stream()
                .map(createCertificationDTO -> {
                    CompanyDTO company;
                    SeasonDTO seasonDTO = seasonGetByIdUseCase.execute(Long.valueOf(createCertificationDTO.getSeasonId()));
                    InspectorDTO inspectorDTO = inspectorGetByIdUseCase.execute(createCertificationDTO.getInspectorId());

                    try {
                        company = companyFindByNitService.execute(createCertificationDTO.getNit());
                    } catch (CompanyNotFoundException error) {

                        if (createCertificationDTO.getName() == null || createCertificationDTO.getName().isEmpty()) {
                            throw new CompanyBadRequest(
                                    CompanyErrorCatalog.COMPANY_BAD_REQUEST,
                                    "La empresa con el NIT " + createCertificationDTO.getNit() + " no existe y falta la razón social para crearla."
                            );
                        }

                        company = CompanyDTO.builder()
                                .nit(createCertificationDTO.getNit())
                                .email(createCertificationDTO.getEmail())
                                .phone(createCertificationDTO.getPhone())
                                .name(createCertificationDTO.getName())
                                .certifications(new ArrayList<>())
                                .build();
                        company = companyCreateUseCase.execute(company);
                    }
                    Long consecutive = generateConsecutive(seasonConsecutives, Long.valueOf(createCertificationDTO.getSeasonId()));

                    boolean certificationExists = company.getCertifications().stream()
                            .anyMatch(cert -> createCertificationDTO.getAddress() != null &&
                                    createCertificationDTO.getAddress().equals(cert.getAddress()) &&
                                    cert.isActive());
                    if (certificationExists) {
                        // Si ya existe un certificado activo con la misma dirección, no creamos otro.
                        return null;
                    }

                    CertificationDTO certificationDTO = CertificationDTO.builder()
                            .consecutive(consecutive)
                            .address(createCertificationDTO.getAddress())
                            .nameCompany(createCertificationDTO.getName())
                            .phone(createCertificationDTO.getPhone())
                            .email(createCertificationDTO.getEmail())
                            .ciu(createCertificationDTO.getCiu())
                            .clientConsecutive(createCertificationDTO.getClientConsecutive())
                            .validateBy(createCertificationDTO.getValidateBy() != null ? createCertificationDTO.getValidateBy() : 1)
                            .date(createCertificationDTO.getDate())
                            .company(company)
                            .inspector(inspectorDTO)
                            .season(seasonDTO)
                            .build();

                    company.getCertifications().add(certificationDTO);

                    return certificationDTO;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return iCertificationRepository.saveAll(certifications);
    }

    public CertificationDTO execute (CreateCertificationDTO createCertificationDTO){

        CompanyDTO company;
        SeasonDTO seasonDTO = seasonGetByIdUseCase.execute(Long.valueOf(createCertificationDTO.getSeasonId()));
        InspectorDTO inspectorDTO = inspectorGetByIdUseCase.execute(createCertificationDTO.getInspectorId());

        try {
            company = companyFindByNitService.execute(createCertificationDTO.getNit());
        } catch (CompanyNotFoundException error) {

            company = CompanyDTO.builder()
                    .nit(createCertificationDTO.getNit())
                    .email(createCertificationDTO.getEmail())
                    .phone(createCertificationDTO.getPhone())
                    .name(createCertificationDTO.getName())
                    .certifications(new ArrayList<>())
                    .build();
            company = companyCreateUseCase.execute(company);
        }
        Long consecutive = generateConsecutive(Long.valueOf(createCertificationDTO.getSeasonId()));

        System.out.println(createCertificationDTO.getClientConsecutive());
        CertificationDTO certificationDTO = CertificationDTO.builder()
                .consecutive(consecutive)
                .clientConsecutive(createCertificationDTO.getClientConsecutive())
                .validateBy(createCertificationDTO.getValidateBy() != null ? createCertificationDTO.getValidateBy() : 1)
                .date(createCertificationDTO.getDate())
                .company(company)
                .inspector(inspectorDTO)
                .season(seasonDTO)
                .build();

        company.getCertifications().add(certificationDTO);

        return iCertificationRepository.save(certificationDTO);
    }

    private Long generateConsecutive(Map<Long, Long> seasonConsecutives, Long seasonId) {
        // Obtener el último consecutivo del mapa o desde la base de datos si no está en el mapa
        Long lastConsecutive = seasonConsecutives.getOrDefault(seasonId, null);
        if (lastConsecutive == null) {
            lastConsecutive = iCertificationRepository.findLastConsecutiveBySeasonId(seasonId)
                    .orElse(0L); // Comienza desde 0 si no se encuentra ningún consecutivo anterior
        }

        // Incrementar el consecutivo y actualizar el mapa
        Long newConsecutive = lastConsecutive + 1;
        seasonConsecutives.put(seasonId, newConsecutive);

        return newConsecutive;
    }

    private Long generateConsecutive(Long seasonId){
        Long lastConsecutive = iCertificationRepository.findLastConsecutiveBySeasonId(seasonId).orElse(0L);
        return lastConsecutive + 1;

    }
}
