package com.bovintech.versionone.domain.certification.usecases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Getter;

public class QrTokenGenerateUseCase {
    private static final String QR_SECRET_KEY = "uZ122HWQHTLZ4fsSPvdqW8/EXEcl5sXAFA2rxZdEhmA=";
    @Getter
    private static final Algorithm QR_ALGORITHM = Algorithm.HMAC256(QR_SECRET_KEY);

    public String execute(String certificateId) {

        return JWT.create()
                .withSubject(certificateId)
                .withIssuer("qrToken")
                .withClaim("scope", "read-only") // Indicador de que es solo lectura
                .sign(QR_ALGORITHM);
    }
}
