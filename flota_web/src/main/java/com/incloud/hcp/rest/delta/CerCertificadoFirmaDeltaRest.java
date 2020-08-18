/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/rest/EntitydeltaResource.java.e.vm
 */
package com.incloud.hcp.rest.delta;

import com.incloud.hcp._security.SystemLoggedUser;
import com.incloud.hcp._security.UserSession;
import com.incloud.hcp.common.BindingErrorsResponse;
import com.incloud.hcp.domain.CerCertificadoFirma;
import com.incloud.hcp.rest.CerCertificadoFirmaRest;
import com.incloud.hcp.service.dto.CerCertificadoFirmaEntradaDto;
import com.incloud.hcp.util.Utils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/cerCertificadoFirma")
public class CerCertificadoFirmaDeltaRest extends CerCertificadoFirmaRest {

    @Autowired
    private SystemLoggedUser systemLoggedUser;

    @ApiOperation(value = "Devuelve lista de Certificados Firma de acuerdo a los parametros ingresados", produces = "application/json")
    @PostMapping(value = "/_findByPorAprobador", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CerCertificadoFirma>> findByPorAprobador(
            @RequestBody CerCertificadoFirmaEntradaDto cerCertificadoFirmaEntradaDto,
            BindingResult bindingResult
    ) throws URISyntaxException {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        log.debug(this.NOMBRE_CLASE + " - Ingresando findByPorAprobador by:" + cerCertificadoFirmaEntradaDto.toString());

        try {
            UserSession userSession = this.systemLoggedUser.getUserSession();
            cerCertificadoFirmaEntradaDto.setUserSession(userSession);
            return Optional.ofNullable(this.cerCertificadoFirmaDeltaService.findByPorAprobador(cerCertificadoFirmaEntradaDto))
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        }
        catch (Exception e) {
            if (this.devuelveRuntimeException) {
                String error = Utils.obtieneMensajeErrorExceptionDepurado(e);
                throw new RuntimeException(error);
            }
            headers = this.devuelveErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

}
