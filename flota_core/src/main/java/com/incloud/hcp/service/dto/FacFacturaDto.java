package com.incloud.hcp.service.dto;


import com.incloud.hcp.domain.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class FacFacturaDto {

    private boolean esNuevaFactura;
    private FacFactura facFactura;
    private List<FacFacturaCertificado> facFacturaCertificadoList;
    private List<FacDocumentoAdjunto> facDocumentoAdjuntoList;
    private List<FacImputacion> facImputacionList;
    private List<FacContacto> facContactoList;

    private List<FacDocumentoAdjunto> facDocumentoAdjuntoFacturaList;
    private List<FacDocumentoAdjunto> facDocumentoAdjuntoGuiaList;
    private List<FacDocumentoAdjunto> facDocumentoAdjuntoCdrList;
    private List<FacDocumentoAdjunto> facDocumentoAdjuntoOtrosList;

    private List<FacHistorial> facHistorialList;

    //Datos de salida
    private FacHistorial facHistorialGenerado;


}


