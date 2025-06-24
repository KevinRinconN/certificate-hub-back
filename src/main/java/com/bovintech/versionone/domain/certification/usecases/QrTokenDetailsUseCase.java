package com.bovintech.versionone.domain.certification.usecases;

import com.auth0.jwt.JWT;
import com.bovintech.versionone.domain.auth.model.dto.Jwt;

public class QrTokenDetailsUseCase {

    public String execute(String token){
        return JWT.require(QrTokenGenerateUseCase.getQR_ALGORITHM())
                .build()
                .verify(token)
                .getSubject();
    }

}
