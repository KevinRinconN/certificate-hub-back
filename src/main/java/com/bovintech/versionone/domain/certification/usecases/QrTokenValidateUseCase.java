package com.bovintech.versionone.domain.certification.usecases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class QrTokenValidateUseCase {
    public boolean execute (String jwt){
        try {
            JWT.require(QrTokenGenerateUseCase.getQR_ALGORITHM())
                    .build()
                    .verify(jwt);
            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }
}
