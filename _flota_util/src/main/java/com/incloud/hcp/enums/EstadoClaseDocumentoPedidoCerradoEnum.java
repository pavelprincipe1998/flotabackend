package com.incloud.hcp.enums;

public enum EstadoClaseDocumentoPedidoCerradoEnum {

    PEDIDO_COGA("NCOG"),
    PEDIDO_TGP("NTGP"),
    S_ENTREGA_COGA("SCOG"),
    S_ENTREGA_TGPE("STGP")
    ;

    private final String estado;

    EstadoClaseDocumentoPedidoCerradoEnum(String estado)  {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }
}
