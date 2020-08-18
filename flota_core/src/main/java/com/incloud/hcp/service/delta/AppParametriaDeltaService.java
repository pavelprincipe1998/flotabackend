/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/dto/EntitydeltaDTO.java.e.vm
 */
package com.incloud.hcp.service.delta;

import com.incloud.hcp.domain.AppParametria;
import com.incloud.hcp.service.AppParametriaService;
import com.incloud.hcp.service.dto.MtrHistorialAprobarSalidaDto;

/**
 * Simple Interface for AppParametria.
 */
public interface AppParametriaDeltaService extends AppParametriaService {

    Boolean devuelveApagarCertificado() throws Exception;

    AppParametria grabarApagarCertificado(Boolean apagar) throws Exception;

    MtrHistorialAprobarSalidaDto devuelveHistorialAprobar() throws Exception;

}
