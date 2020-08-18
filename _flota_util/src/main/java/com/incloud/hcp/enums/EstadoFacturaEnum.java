package com.incloud.hcp.enums;

public enum EstadoFacturaEnum {

    INGRESADA("FAIN"),
    EN_REVISION_CUPA("FARE"),
    APROBADA("FAAP"),
    RECHAZADA("FARE") ;

    private final String estado;

    EstadoFacturaEnum(String estado)  {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

}
