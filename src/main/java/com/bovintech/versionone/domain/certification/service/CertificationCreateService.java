package com.bovintech.versionone.domain.certification.service;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.service.InspectorFindByIdService;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CreateCertificationDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.company.model.CompanyDTO;
import com.bovintech.versionone.domain.company.model.exception.CompanyNotFoundException;
import com.bovintech.versionone.domain.company.service.CompanyCreateService;
import com.bovintech.versionone.domain.company.service.CompanyGetByNameService;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.service.SeasonGetByIdService;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CertificationCreateService {
    private final ICertificationRepository iCertificationRepository;
    private final CompanyCreateService companyCreateService;
    private final CompanyGetByNameService companyGetByNameService;
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
                        company = companyGetByNameService.execute(createCertificationDTO.getName());
                    } catch (CompanyNotFoundException error) {

                        company = CompanyDTO.builder()
                                .nit(createCertificationDTO.getNit())
                                .ciu(createCertificationDTO.getCiu())
                                .email(createCertificationDTO.getEmail())
                                .phone(createCertificationDTO.getPhone())
                                .name(createCertificationDTO.getName())
                                .address(createCertificationDTO.getAddress())
                                .certifications(new ArrayList<>())
                                .build();
                        company = companyCreateService.execute(company);
                    }
                    Long consecutive = generateConsecutive(seasonConsecutives, Long.valueOf(createCertificationDTO.getSeasonId()));

                    CertificationDTO certificationDTO = CertificationDTO.builder()
                            .consecutive(consecutive)
                            .validateBy(createCertificationDTO.getValidateBy() != null ? createCertificationDTO.getValidateBy() : 1)
                            .date(createCertificationDTO.getDate())
                            .company(company)
                            .inspector(inspectorDTO)
                            .season(seasonDTO)
                            .build();

                    company.getCertifications().add(certificationDTO);

                    return certificationDTO;
                })
                .collect(Collectors.toList());

        return iCertificationRepository.saveAll(certifications);
    }

    public CertificationDTO execute (CreateCertificationDTO createCertificationDTO){

        CompanyDTO company;
        SeasonDTO seasonDTO = seasonGetByIdUseCase.execute(Long.valueOf(createCertificationDTO.getSeasonId()));
        InspectorDTO inspectorDTO = inspectorGetByIdUseCase.execute(createCertificationDTO.getInspectorId());

        try {
            company = companyGetByNameService.execute(createCertificationDTO.getName());
        } catch (CompanyNotFoundException error) {

            company = CompanyDTO.builder()
                    .nit(createCertificationDTO.getNit())
                    .ciu(createCertificationDTO.getCiu())
                    .email(createCertificationDTO.getEmail())
                    .phone(createCertificationDTO.getPhone())
                    .name(createCertificationDTO.getName())
                    .address(createCertificationDTO.getAddress())
                    .certifications(new ArrayList<>())
                    .build();
            company = companyCreateService.execute(company);
        }
        Long consecutive = generateConsecutive(Long.valueOf(createCertificationDTO.getSeasonId()));

        CertificationDTO certificationDTO = CertificationDTO.builder()
                .consecutive(consecutive)
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
