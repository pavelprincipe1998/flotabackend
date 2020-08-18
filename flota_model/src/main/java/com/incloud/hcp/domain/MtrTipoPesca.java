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
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "mtr_tipo_pesca")
//@Audited
//@AuditTable("_audi_MTR_TIPO_PESCA")
public class MtrTipoPesca extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(MtrTipoPesca.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String nombre;
    private String inubc;

    @Override
    public String entityClassName() {
        return MtrTipoPesca.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "mtr_tipo_pesca_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_mtr_tipo_pesca")
    @Id
    @SequenceGenerator(name = "seq_mtr_tipo_pesca", sequenceName = "seq_mtr_tipo_pesca", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public MtrTipoPesca id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [nombre] ------------------------

    @NotEmpty(message = "{message.mtrTipoPesca.nombre.requerido}")
    @Size(max = 100, message = "{message.mtrTipoPesca.nombre.sizeMax} {max} {message.caracter}")
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MtrTipoPesca nombre(String nombre) {
        setNombre(nombre);
        return this;
    }
    // -- [inubc] ------------------------

    @Size(max = 1, message = "{message.mtrTipoPesca.inubc.sizeMax} {max} {message.caracter}")
    @Column(name = "inubc", length = 1)
    public String getInubc() {
        return inubc;
    }

    public void setInubc(String inubc) {
        this.inubc = inubc;
    }

    public MtrTipoPesca inubc(String inubc) {
        setInubc(inubc);
        return this;
    }

    /**
     * Apply the default values.
     */
    public MtrTipoPesca withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof MtrTipoPesca && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this MtrTipoPesca instance.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("nombre", getNombre()) //
                .add("inubc", getInubc()) //
                .toString();
    }
}
