package com.incloud.hcp.common.enums;

public enum AppParametriaModuloEnum {

    EMAIL("EMAIL"),
    PARAMETRIA("PARAMETRIA"),
    SESSION_VERSION("SESSION_VERSION"),
    PROCESO("PROCESO"),
    CARGA_EXCEL("CARGA_EXCEL");

    private final String estado;

    AppParametriaModuloEnum(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }
}
