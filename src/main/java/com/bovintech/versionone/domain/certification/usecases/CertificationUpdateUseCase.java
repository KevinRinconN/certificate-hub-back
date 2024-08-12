package com.bovintech.versionone.domain.certification.usecases;

import com.bovintech.versionone.domain.Inspector.model.dto.InspectorDTO;
import com.bovintech.versionone.domain.Inspector.usecases.InspectorGetByIdUseCase;
import com.bovintech.versionone.domain.certification.mapper.CertificationMapper;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CertificationUpdateDTO;
import com.bovintech.versionone.domain.certification.port.repository.ICertificationRepository;
import com.bovintech.versionone.domain.season.model.SeasonDTO;
import com.bovintech.versionone.domain.season.usecases.SeasonGetByIdUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationUpdateUseCase {
    private final ICertificationRepository iCertificationRepository;
    private final CertificationGetByIdUseCase certificationGetByIdUseCase;
    private final SeasonGetByIdUseCase seasonGetByIdUseCase;
    private final InspectorGetByIdUseCase inspectorGetByIdUseCase;

    public CertificationDTO execute(Long id, CertificationUpdateDTO updateDTO){
        CertificationDTO certificationDTO = certificationGetByIdUseCase.execute(id);

        if(updateDTO.getSeasonId() != null){
            SeasonDTO season = seasonGetByIdUseCase.execute(updateDTO.getSeasonId());
            certificationDTO.setSeason(season);
        }

        if(updateDTO.getInspectorId() != null){
            InspectorDTO inspector = inspectorGetByIdUseCase.execute(updateDTO.getInspectorId());
            certificationDTO.setInspector(inspector);
        }

        CertificationMapper.INSTANCE.toUpdateFromDto(updateDTO, certificationDTO);
        return iCertificationRepository.save(certificationDTO);
    }
}
