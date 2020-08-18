/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/dto/EntityDTO.java.e.vm
 */
package com.incloud.hcp.service;

import com.incloud.hcp.common.graph.GraphBean;
import com.incloud.hcp.domain.FacContacto;
import com.incloud.hcp.domain.MtrSector;
import com.incloud.hcp.domain.response.FacContactoResponse;
import com.incloud.hcp.service._framework.JPACustomService;

/**
 * Simple Interface for FacContacto.
 */
public interface FacContactoService extends JPACustomService<FacContactoResponse, FacContacto, Integer> {

    Long countByMtrSector(MtrSector mtrSector);

    GraphBean graphByMtrSector();

}