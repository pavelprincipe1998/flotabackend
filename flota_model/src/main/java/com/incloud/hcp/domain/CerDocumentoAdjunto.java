/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/domain/Entity.java.e.vm
 */
package com.incloud.hcp.domain;

import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Centificado Documento
 */
@Entity
@Table(name = "cer_documento_adjunto")
//@Audited
//@AuditTable("_audi_cer_documento_adjunto")
public class CerDocumentoAdjunto extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(CerDocumentoAdjunto.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String carpetaId;
    private String archivoId;
    private String archivoNombre;
    private String archivoTipo;
    private String rutaCatalogo;
    private String tipoAdjunto;
    private String adjuntoAprobador;
    private Long size;

    // Many to one
    private CerCertificado cerCertificado;

    @Override
    public String entityClassName() {
        return CerDocumentoAdjunto.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "cer_documento_adjunto_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_cer_documento_adjunto")
    @Id
    @SequenceGenerator(name = "seq_cer_documento_adjunto", sequenceName = "seq_cer_documento_adjunto", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public CerDocumentoAdjunto id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [carpetaId] ------------------------

    @NotEmpty(message = "{message.cerDocumentoAdjunto.carpetaId.requerido}")
    @Size(max = 60, message = "{message.cerDocumentoAdjunto.carpetaId.sizeMax} {max} {message.caracter}")
    @Column(name = "carpeta_id", nullable = false, length = 60)
    public String getCarpetaId() {
        return carpetaId;
    }

    public void setCarpetaId(String carpetaId) {
        this.carpetaId = carpetaId;
    }

    public CerDocumentoAdjunto carpetaId(String carpetaId) {
        setCarpetaId(carpetaId);
        return this;
    }
    // -- [archivoId] ------------------------

    @NotEmpty(message = "{message.cerDocumentoAdjunto.archivoId.requerido}")
    @Size(max = 60, message = "{message.cerDocumentoAdjunto.archivoId.sizeMax} {max} {message.caracter}")
    @Column(name = "archivo_id", nullable = false, length = 60)
    public String getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(String archivoId) {
        this.archivoId = archivoId;
    }

    public CerDocumentoAdjunto archivoId(String archivoId) {
        setArchivoId(archivoId);
        return this;
    }
    // -- [archivoNombre] ------------------------

    @NotEmpty(message = "{message.cerDocumentoAdjunto.archivoNombre.requerido}")
    @Size(max = 255, message = "{message.cerDocumentoAdjunto.archivoNombre.sizeMax} {max} {message.caracter}")
    @Column(name = "archivo_nombre", nullable = false)
    public String getArchivoNombre() {
        return archivoNombre;
    }

    public void setArchivoNombre(String archivoNombre) {
        this.archivoNombre = archivoNombre;
    }

    public CerDocumentoAdjunto archivoNombre(String archivoNombre) {
        setArchivoNombre(archivoNombre);
        return this;
    }
    // -- [archivoTipo] ------------------------

    @NotEmpty(message = "{message.cerDocumentoAdjunto.archivoTipo.requerido}")
    @Size(max = 100, message = "{message.cerDocumentoAdjunto.archivoTipo.sizeMax} {max} {message.caracter}")
    @Column(name = "archivo_tipo", nullable = false, length = 100)
    public String getArchivoTipo() {
        return archivoTipo;
    }

    public void setArchivoTipo(String archivoTipo) {
        this.archivoTipo = archivoTipo;
    }

    public CerDocumentoAdjunto archivoTipo(String archivoTipo) {
        setArchivoTipo(archivoTipo);
        return this;
    }
    // -- [rutaCatalogo] ------------------------

    @NotEmpty(message = "{message.cerDocumentoAdjunto.rutaCatalogo.requerido}")
    @Size(max = 1000, message = "{message.cerDocumentoAdjunto.rutaCatalogo.sizeMax} {max} {message.caracter}")
    @Column(name = "ruta_catalogo", nullable = false, length = 1000)
    public String getRutaCatalogo() {
        return rutaCatalogo;
    }

    public void setRutaCatalogo(String rutaCatalogo) {
        this.rutaCatalogo = rutaCatalogo;
    }

    public CerDocumentoAdjunto rutaCatalogo(String rutaCatalogo) {
        setRutaCatalogo(rutaCatalogo);
        return this;
    }
    // -- [tipoAdjunto] ------------------------

    @NotEmpty(message = "{message.cerDocumentoAdjunto.tipoAdjunto.requerido}")
    @Size(max = 10, message = "{message.cerDocumentoAdjunto.tipoAdjunto.sizeMax} {max} {message.caracter}")
    @Column(name = "tipo_adjunto", nullable = false, length = 10)
    public String getTipoAdjunto() {
        return tipoAdjunto;
    }

    public void setTipoAdjunto(String tipoAdjunto) {
        this.tipoAdjunto = tipoAdjunto;
    }

    public CerDocumentoAdjunto tipoAdjunto(String tipoAdjunto) {
        setTipoAdjunto(tipoAdjunto);
        return this;
    }
    // -- [adjuntoAprobador] ------------------------

    @Size(max = 1, message = "{message.cerDocumentoAdjunto.adjuntoAprobador.sizeMax} {max} {message.caracter}")
    @Column(name = "adjunto_aprobador", length = 1)
    public String getAdjuntoAprobador() {
        return adjuntoAprobador;
    }

    public void setAdjuntoAprobador(String adjuntoAprobador) {
        this.adjuntoAprobador = adjuntoAprobador;
    }

    public CerDocumentoAdjunto adjuntoAprobador(String adjuntoAprobador) {
        setAdjuntoAprobador(adjuntoAprobador);
        return this;
    }
    // -- [size] ------------------------

    @Digits(integer = 19, fraction = 0)
    @Column(name = "\"size\"", precision = 19)
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public CerDocumentoAdjunto size(Long size) {
        setSize(size);
        return this;
    }

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: CerDocumentoAdjunto.cerCertificado ==> CerCertificado.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "cer_certificado_id", nullable = false)
    @ManyToOne
    public CerCertificado getCerCertificado() {
        return cerCertificado;
    }

    /**
     * Set the {@link #cerCertificado} without adding this CerDocumentoAdjunto instance on the passed {@link #cerCertificado}
     */
    public void setCerCertificado(CerCertificado cerCertificado) {
        this.cerCertificado = cerCertificado;
    }

    public CerDocumentoAdjunto cerCertificado(CerCertificado cerCertificado) {
        setCerCertificado(cerCertificado);
        return this;
    }

    /**
     * Apply the default values.
     */
    public CerDocumentoAdjunto withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof CerDocumentoAdjunto && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this CerDocumentoAdjunto instance.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("cerCertificado", getCerCertificado()) //    
                .add("carpetaId", getCarpetaId()) //
                .add("archivoId", getArchivoId()) //
                .add("archivoNombre", getArchivoNombre()) //
                .add("archivoTipo", getArchivoTipo()) //
                .add("rutaCatalogo", getRutaCatalogo()) //
                .add("tipoAdjunto", getTipoAdjunto()) //
                .add("adjuntoAprobador", getAdjuntoAprobador()) //
                .add("size", getSize()) //
                .toString();
    }
}