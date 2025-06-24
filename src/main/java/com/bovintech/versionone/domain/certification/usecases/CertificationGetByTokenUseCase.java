package com.bovintech.versionone.domain.certification.usecases;

import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.constant.CertificationErrorCatalog;
import com.bovintech.versionone.domain.certification.model.exception.CertificationQrInvalidException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CertificationGetByTokenUseCase {
    private final QrTokenValidateUseCase qrTokenValidateUseCase;
    private final QrTokenDetailsUseCase qrTokenDetailsUseCase;
    private final CertificationGetByIdUseCase certificationGetByIdUseCase;

    public CertificationDTO execute (String token){
        boolean isValid = qrTokenValidateUseCase.execute(token);

        if (!isValid) throw new CertificationQrInvalidException(CertificationErrorCatalog.CERTIFICATION_QR_INVALID, "El token "+token+" no es valido");

        Long certificationId = Long.valueOf(qrTokenDetailsUseCase.execute(token));

        return certificationGetByIdUseCase.execute(certificationId);
    }
}
