package com.bovintech.versionone.infrastructure.certification.rest.controller;

import com.bovintech.versionone.application.certification.command.CertificationCreateHandler;
import com.bovintech.versionone.application.certification.command.CertificationDeleteHandler;
import com.bovintech.versionone.application.certification.command.CertificationUpdateHandler;
import com.bovintech.versionone.application.certification.query.CertificationFindHandler;
import com.bovintech.versionone.application.certification.query.CertificationGetByIdHandler;
import com.bovintech.versionone.application.certification.query.CertificationGetByNitCompanyHandler;
import com.bovintech.versionone.application.certification.query.CertificationGetByTokenHandler;
import com.bovintech.versionone.domain.certification.model.CertificationDTO;
import com.bovintech.versionone.domain.certification.model.CertificationUpdateDTO;
import com.bovintech.versionone.domain.certification.model.CreateCertificationDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateDTO;
import com.bovintech.versionone.domain.certification.model.certificate.CertificateSearchParams;
import com.bovintech.versionone.infrastructure.util.ResponseHandler;
import com.bovintech.versionone.infrastructure.util.ValidationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certification")
@RequiredArgsConstructor
@Validated
public class CertificationController {

    private final CertificationCreateHandler certificationCreateHandler;
    private final CertificationFindHandler certificationFindHandler;
    private final CertificationGetByIdHandler certificationGetByIdHandler;
    private final CertificationDeleteHandler certificationDeleteHandler;
    private final CertificationUpdateHandler certificationUpdateHandler;
    private final CertificationGetByTokenHandler certificationGetByTokenHandler;
    private final CertificationGetByNitCompanyHandler certificationGetByNitCompanyHandler;

    private final ValidationService validationService;

    @PostMapping
    public ResponseHandler<List<CertificationDTO>> save(@RequestBody @Valid List<@Valid CreateCertificationDTO> certificationDTOs) {
        return ResponseHandler.success("The certifications have been successfully created.", certificationCreateHandler.execute(certificationDTOs));
    }

    @GetMapping
    public ResponseHandler<Page<CertificateDTO>> findAll (@RequestParam(required = false) String nit,
                                                          @RequestParam(required = false) String nameCompany,
                                                          @RequestParam(required = false) List<String> inspectors,
                                                          @RequestParam(required = false) String startDate,
                                                          @RequestParam(required = false) String endDate,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(defaultValue = "id,asc") String sort) throws MethodArgumentNotValidException {
        CertificateSearchParams params = new CertificateSearchParams(nit,nameCompany, startDate, endDate, inspectors, page, size,sort);
        validationService.validate(params, "CertificateSearchParams");
        return ResponseHandler.success("Certifications data successfully",certificationFindHandler.execute(params));
    }

    @GetMapping("/{id}")
    public ResponseHandler<CertificateDTO> findById(@PathVariable Long id){
        CertificateDTO certification = certificationGetByIdHandler.execute(id);
        return ResponseHandler.success("Certification data successfully", certification);
    }

    @GetMapping("/nit/{nit}")
    public ResponseHandler<List<CertificateDTO>> findByNitCompany (@PathVariable String nit){
        List<CertificateDTO> certification = certificationGetByNitCompanyHandler.execute(nit);
        return ResponseHandler.success("Certifications data successfully", certification);
    }

    @GetMapping("/token/{token}")
    public ResponseHandler<CertificateDTO> findByToken(@PathVariable String token){
        CertificateDTO certification = certificationGetByTokenHandler.execute(token);
        return ResponseHandler.success("Certification data successfully", certification);
    }

    @DeleteMapping("/{id}")
    public ResponseHandler<Void> deleteById(@PathVariable Long id){
        certificationDeleteHandler.execute(id);
        return  ResponseHandler.success("Certificado con el id: "+id+" borrado satisfactoriamente");
    }

    @PutMapping("/{id}")
    public ResponseHandler<CertificateDTO> update(@PathVariable Long id, @RequestBody @Valid CertificationUpdateDTO certificationUpdateDTO){
        CertificateDTO certification = certificationUpdateHandler.execute(id, certificationUpdateDTO);
        return ResponseHandler.success("Certification update data successfully", certification);
    }
}
